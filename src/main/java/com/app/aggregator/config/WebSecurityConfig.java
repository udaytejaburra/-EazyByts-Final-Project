package com.app.aggregator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class WebSecurityConfig {
	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf(csrf -> csrf.disable()) // Disable CSRF for API-based authentication
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/", "/home", "/api/news/**", "/api/users/register", "/api/users/login").permitAll() // Allow public access
	            .anyRequest().authenticated() // Protect all other routes
	        )
	        .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)) // Use session-based auth
	        .formLogin(form -> form
	            .loginPage("/login") // Custom login page
	            .permitAll()
	            .successHandler((request, response, authentication) -> {
	                response.sendRedirect("/dashboard"); // Redirect users to dashboard after login
	            })
	        )
	        .logout(logout -> logout
	            .logoutUrl("/logout")
	            .logoutSuccessUrl("/login?logout")
	            .permitAll()
	        );

	    return http.build();
	}

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(); // Secure password storage
    }
}