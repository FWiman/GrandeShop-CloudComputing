package org.example.javaweb.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        return http
                .authorizeHttpRequests(registry ->{
                    registry.requestMatchers("/").permitAll();
                    registry.anyRequest().authenticated();
                })
                .oauth2Login(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults())
                .build();
//        http
//                .authorizeHttpRequests(auth -> auth
//                        .requestMatchers("/", "/css/**", "/js/**", "/images/**").permitAll()
//                        .requestMatchers("/admin").authenticated()
//                        .anyRequest().permitAll()
//                )
//                .oauth2Login(Customizer.withDefaults())
//                .logout(logout -> logout
//                        .logoutSuccessUrl("/")
//                        .permitAll()
//                );
//
//        return http.build();
    }
}
