package com.telefonica.mssubscriberinformation.common.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.StaticHeadersWriter;

/**
 * @author dpanquev
 * @version 2021-09-14
 */
@Slf4j
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * Method for define all security
     *
     * @param httpSecurity
     */
    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .headers()
                .xssProtection()
                .block(true)
                .and()
                .addHeaderWriter(new StaticHeadersWriter("X-Content-Security-Policy", "default-src 'self'"))
                .addHeaderWriter(new StaticHeadersWriter("X-XSS-Protection", "1; mode=block"))
                .contentSecurityPolicy("script-src 'self'");
    }
}
