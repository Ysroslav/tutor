package com.bodrov.spring.tutor.database.config;

import com.bodrov.spring.tutor.database.entity.Role;
import com.bodrov.spring.tutor.database.entity.UserRole;
import com.bodrov.spring.tutor.database.repository.RoleRepository;
import com.bodrov.spring.tutor.database.repository.UserRepository;
import com.bodrov.spring.tutor.database.repository.UserRoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    DataSource dataSource;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Autowired
    private RoleRepository roleRepository;

    //@Autowired
    //UserDetailsService userDetailsService;

    /*@Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }*/

    /*@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        /*http.csrf().disable();
        http.authorizeRequests().antMatchers("/", "/welcome", "/secure/department-list",
                "/secure/department-edit","/secure/department-view").permitAll();
        http.authorizeRequests().antMatchers("/staff-card").access("hasAnyRole('ROLE_USER', 'ROLE_ADMIN')");
        http.authorizeRequests().antMatchers("/secure").access("hasAnyRole('ROLE_ADMIN')");
        http.authorizeRequests().and().exceptionHandling().accessDeniedPage("/403");
        http.authorizeRequests().and().formLogin()
                .loginProcessingUrl("/j_spring_security_check")
                .loginPage("/welcome")
                .defaultSuccessUrl("/staff-card")
                .failureUrl("/welcome?error=true")
                .usernameParameter("username")
                .usernameParameter("password")
                .and().logout().logoutUrl("/logout").logoutSuccessUrl("/logoutSuccessful");*/
        http.authorizeRequests()
                .antMatchers("/secure/**").access("hasRole('ROLE_ADMIN')")
                .and().formLogin()
                .loginPage("/login.xhtml").permitAll()
                .defaultSuccessUrl("/secure/admin-main.xhtml")
                .failureUrl("/login.xhtml?error=true");
        http.logout().logoutSuccessUrl("/login.xhtml");
        http.csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth)
            throws Exception {
        /*auth.inMemoryAuthentication().passwordEncoder(NoOpPasswordEncoder.getInstance()).withUser("john.doe")
                .password("1234").roles("USER").and().withUser("jane.doe")
                .password("5678").roles("ADMIN");*/
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        final User.UserBuilder users = User.builder().passwordEncoder(encoder::encode);
        List<UserDetails> list = new ArrayList<>();
        Map<com.bodrov.spring.tutor.database.entity.User, List<Role>> map = getListUserRoles();

        for(Map.Entry entry:map.entrySet()){
            final com.bodrov.spring.tutor.database.entity.User user = (com.bodrov.spring.tutor.database.entity.User)entry.getKey();
            final List<Role> roles = (List)entry.getValue();
            final List<String> roleStrings = new ArrayList<>();
            for(int i = 0; i<roles.size(); i++) roleStrings.add(roles.get(i).getRoleName());
            String[] rolesArr=roleStrings.toArray(new String[roleStrings.size()]);
            UserDetails userDetails = users
                    .username(user.getLogin())
                    .password(user.getPassword())
                    .roles(rolesArr)
                    .build();
            list.add(userDetails);
        }
        /*UserDetails user = users
                .username("user")
                .password("123")
                .roles("USER")
                .build();
        list.add(user);
        UserDetails admin = users
                .username("admin")
                .password("567")
                .roles("USER", "ADMIN")
                .build();
        list.add(admin);*/
        for(int i=0; i<list.size(); i++)
            auth.inMemoryAuthentication().withUser(list.get(i));
    }

    private Map<com.bodrov.spring.tutor.database.entity.User, List<Role>> getListUserRoles(){
        List<com.bodrov.spring.tutor.database.entity.User> list = userRepository.findAll();
        Map<com.bodrov.spring.tutor.database.entity.User, List<Role>> map = new LinkedHashMap<>();

        for(int i =0; i<list.size();i++){
            final com.bodrov.spring.tutor.database.entity.User user = list.get(i);
            List<UserRole> userRoles = userRoleRepository.findAllByUser(user);
            List<Role> roles = new ArrayList<>();
            for(int j =0;j<userRoles.size();j++) roles.add(userRoles.get(j).getRole());
            map.put(user, roles);
        }
        return map;
    }
}
