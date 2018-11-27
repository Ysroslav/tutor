package com.bodrov.spring.tutor.database.config;

import com.bodrov.spring.tutor.database.beans.HandlerAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Autowired
    DataSource dataSource;

    @Autowired
    private HandlerAuthorize handlerAuthorize;

    @Bean
    public UserDetailsService userDetailsService() throws Exception {
        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(User.withUsername("user").password(encoder().encode("userPass")).roles("USER").build());
        manager.createUser(User.withUsername("admin").password(encoder().encode("adminPass")).roles("ADMIN").build());
        return manager;
    }

    @Bean
    public static PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Configuration
    @Order(1)
    public static class AppConfigurationAdapter extends WebSecurityConfigurerAdapter {

        public AppConfigurationAdapter(){
            super();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("admin").password(encoder().encode("admin")).roles("ADMIN");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception{
            http.authorizeRequests()
                    .antMatchers("/secure/**")
                    .access("hasRole('ADMIN')")
                    .and().formLogin()
                    .loginPage("/login.xhtml")
                    .defaultSuccessUrl("/secure/admin-main.xhtml")
                    .failureUrl("/login.xhtml").and()
                    .logout().logoutSuccessUrl("/login.xhtml")
                    .deleteCookies("JSESSIONID")
                    .and().csrf().disable();
        }
    }

    @Configuration
    @Order(2)
    public static class App2ConfigurationAdapter extends WebSecurityConfigurerAdapter {

        public App2ConfigurationAdapter() {
            super();
        }

        @Override
        protected void configure(AuthenticationManagerBuilder auth) throws Exception {
            auth.inMemoryAuthentication().withUser("user").password(encoder().encode("user")).roles("USER");
        }

        @Override
        protected void configure(HttpSecurity http) throws Exception {
            http.authorizeRequests()
                    .antMatchers("/teacher/**")
                    .access("hasRole('USER')")
                    .and().formLogin()
                    .loginPage("/login.xhtml")
                    .defaultSuccessUrl("/teacher/teacher-main.xhtml")
                    .failureUrl("/login.xhtml").and()
                    .logout().logoutSuccessUrl("/login.xhtml")
                    .deleteCookies("JSESSIONID")
                    .and().csrf().disable();
        }
    }


    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        final User.UserBuilder users = User.builder().passwordEncoder(encoder::encode);
        List<UserDetails> list = new ArrayList<>();
        Map<com.bodrov.spring.tutor.database.entity.User, List<Role>> map = handlerAuthorize.getListUserRoles();

        for(Map.Entry entry:map.entrySet()){
            final com.bodrov.spring.tutor.database.entity.User user = (com.bodrov.spring.tutor.database.entity.User)entry.getKey();
            final List<Role> roles = (List)entry.getValue();
            final List<String> roleStrings = new ArrayList<>();
            for(int i = 0; i<roles.size(); i++){
                roleStrings.add(roles.get(i).getRoleName());
            }
            String[] rolesArr=roleStrings.toArray(new String[roleStrings.size()]);
            UserDetails userDetails = users
                    .username(user.getLogin())
                    .password(user.getPassword())
                    .roles(rolesArr)
                    .build();
            list.add(userDetails);
        }
        for(int i=0; i<list.size(); i++) {
            auth.inMemoryAuthentication().withUser(list.get(i));
        }
    }*/
}
