package com.example.demo.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.client.OAuth2LoginConfigurer;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class OAthun2{
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests -> authorizeRequests
                        .requestMatchers("/weather").authenticated() // Require authentication for /weather
                        .anyRequest().permitAll()) // Allow all other requests without authentication
                .oauth2Login(OAuth2LoginConfigurer::permitAll) // Allow OAuth2 login
                .formLogin(Customizer.withDefaults()); // Default form login configuration

        return http.build();
    }
}
