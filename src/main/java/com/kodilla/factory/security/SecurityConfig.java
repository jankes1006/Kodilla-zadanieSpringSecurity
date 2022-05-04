package com.kodilla.factory.security;

import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Bean
    public static NoOpPasswordEncoder passwordEncoder() {
        return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();

        http.authorizeRequests()
                .mvcMatchers(HttpMethod.GET, "/products/**")
                .hasAnyRole("CLIENT", "SALARY", "BOSS")
                .mvcMatchers(HttpMethod.POST, "/products/**")
                .hasAnyRole("SALARY", "BOSS")
                .mvcMatchers(HttpMethod.DELETE, "/products/**")
                .hasAnyRole("BOSS")
                .anyRequest()
                .fullyAuthenticated()
                .and()
                .httpBasic();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("client").password("client").roles("CLIENT");
        auth.inMemoryAuthentication().withUser("boss").password("boss").roles("BOSS");
        auth.inMemoryAuthentication().withUser("salary").password("salary").roles("SALARY");
    }
}
