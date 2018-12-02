package com.bodrov.spring.tutor.database.config;

import com.bodrov.spring.tutor.database.beans.HandlerAuthorize;
import com.bodrov.spring.tutor.database.entity.Role;
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

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig  extends WebSecurityConfigurerAdapter {

    //@Autowired
    //DataSource dataSource;

    @Autowired
    private HandlerAuthorize handlerAuthorize;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
            http.authorizeRequests()
                    .antMatchers("/secure/**")
                    .access("hasRole('ROLE_SUPERADMIN') and hasRole('ROLE_USER')")
                    .antMatchers("/teacher/**")
                    .access("hasRole('ROLE_ADMIN')")
                    .antMatchers("/user/**")
                    .access("hasRole('ROLE_USER')")
                    .and().formLogin()
                    .loginPage("/login.xhtml").permitAll()
                    .defaultSuccessUrl("/default")
                    .failureUrl("/login.xhtml");
            http.logout().logoutSuccessUrl("/login.xhtml");
            http.csrf().disable();
    }

    @Autowired
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
    }
}
