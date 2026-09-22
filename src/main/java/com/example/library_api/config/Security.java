package com.example.library_api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class Security {

    @Bean
    InMemoryUserDetailsManager inMemoryUserDetailsManager() {
        UserDetails john = User.builder()
                .username("john")
                .password("{noop}john123")
                .roles("USER")
                .build();

        UserDetails mike = User.builder()
                .username("mike")
                .password("{noop}mike123")
                .roles("USER", "MANAGER") // MANAGER hem USER hem MANAGER yetkilerine sahip olur
                .build();

        return new InMemoryUserDetailsManager(john, mike);
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        http.authorizeHttpRequests(configurer ->
                configurer
                        // GET istekleri (USER ve MANAGER erişebilir)
                        .requestMatchers(HttpMethod.GET, "/api/users", "/api/users/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/books", "/api/books/**").hasRole("USER")
                        .requestMatchers(HttpMethod.GET, "/api/loans", "/api/loans/**").hasRole("USER")

                        // POST, PUT, DELETE istekleri (Sadece MANAGER erişebilir)
                        .requestMatchers(HttpMethod.POST, "/api/users").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/users/**").hasRole("MANAGER")

                        .requestMatchers(HttpMethod.POST, "/api/books").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/books/**").hasRole("MANAGER")

                        .requestMatchers(HttpMethod.POST, "/api/loans").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.DELETE, "/api/loans/**").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.POST, "/api/loans/borrow").hasRole("MANAGER")
                        .requestMatchers(HttpMethod.PUT, "/api/loans/return/{loanId}").hasRole("MANAGER")

                        // Geriye kalan tüm istekleri doğrulamaya tabi tut
                        .anyRequest().authenticated()
        );

        http.httpBasic(Customizer.withDefaults());
        http.csrf(csrf -> csrf.disable());

        return http.build();
    }
}