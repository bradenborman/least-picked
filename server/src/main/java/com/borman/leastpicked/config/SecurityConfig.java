package com.borman.leastpicked.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(final HttpSecurity http) throws Exception {
        http.csrf().disable();

        //Allows h2 data
        http.headers().frameOptions().disable();

        http.authorizeRequests()
                .antMatchers("/**")
                .access("hasRole('USER')")
                .and()
                .oauth2Login();

    }

}