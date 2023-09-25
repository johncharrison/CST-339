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

import static org.springframework.security.config.Customizer.withDefaults;

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
                                                                "/images/*", "/swagger-ui/*")
                                                .permitAll())
                                .authorizeHttpRequests((r) -> r
                                                .requestMatchers("/products/**", "/products", "/css/*", "/js/*",
                                                                "/images/*", "/api/**", "/api/products/*",
                                                                "/api/users/*", "/api/orders/*")
                                                .authenticated())
                                .formLogin((form) -> form
                                                .loginPage("/login")
                                                .defaultSuccessUrl("/products", true)
                                                .permitAll())
                                .userDetailsService(userDetailsService)
                                .httpBasic(withDefaults())
                                .authorizeHttpRequests((r) -> r
                                                .requestMatchers("/api/**", "/api/products/*",
                                                                "/api/users/*", "/api/orders/*")
                                                .authenticated())
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
