package com.example.ProyectoGalter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

//    private final LogoutHandler logoutHandler;
//    public SecurityConfig(LogoutHandler logoutHandler){
//        this.logoutHandler = logoutHandler;
//    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .requestMatchers("/", "/static/**").permitAll()
                .anyRequest().permitAll()
                .and().oauth2Login()
                .and().csrf().disable();
//                .and().logout()
//                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
//                .addLogoutHandler(logoutHandler);
        return http.build();
//        return http.oauth2Login()
//                .and().build();
    }
}


