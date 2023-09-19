package com.gcu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.gcu.service.security.SecurityUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

        @Autowired
        private SecurityUserDetailsService userDetailsService;

        @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
                return http
                                .csrf(csrf -> csrf.disable())
                                .authorizeHttpRequests((requests) -> requests
                                                .requestMatchers("/", "/register", "/css/*", "/js/*",
                                                                "/images/*")
                                                .permitAll())
                                .authorizeHttpRequests((r) -> r
                                                .requestMatchers("/products/**", "/products", "/css/*", "/js/*",
                                                                "/images/*")
                                                .authenticated())
                                .formLogin((form) -> form
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/products", true)
                                                .permitAll())
                                .userDetailsService(userDetailsService)
                                .logout(logout -> logout
                                                .logoutUrl("/logout")
                                                .invalidateHttpSession(true)
                                                .clearAuthentication(true)
                                                .permitAll()
                                                .logoutSuccessUrl("/"))
                                .build();
        }

        @Bean
        PasswordEncoder passwordEncoder() {
                return new BCryptPasswordEncoder();
        }

}
