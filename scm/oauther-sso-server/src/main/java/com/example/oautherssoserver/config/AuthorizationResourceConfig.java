package com.example.oautherssoserver.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

/**
 * @author sleepwalker
 */
@Order(6)
@Configuration
@EnableResourceServer
public class AuthorizationResourceConfig extends ResourceServerConfigurerAdapter{

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.requestMatchers()
                .antMatchers("/user/**")
                .and()
                .authorizeRequests().anyRequest().authenticated()
                .and().csrf().disable();
    }


}
