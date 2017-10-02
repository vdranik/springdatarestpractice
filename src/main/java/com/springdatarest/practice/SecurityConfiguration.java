package com.springdatarest.practice;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by User on 10/2/2017.
 */
@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

    @Override
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("Volodymyr").password("test").roles("USER")
                .and().withUser("admin").password("admin").roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
       http.httpBasic().and().authorizeRequests()
               .antMatchers(HttpMethod.POST, "/events").hasRole("ADMIN")
               .antMatchers(HttpMethod.PUT,"/events/**").hasRole("ADMIN")
               .antMatchers(HttpMethod.PATCH,"/events/**").hasRole("ADMIN")
               .and().csrf().disable();
    }
}
