//package com.pawan.LLD.lld.authentication.config;
//
//import com.pawan.LLD.lld.authentication.service.CustomUserDetailsService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.Customizer;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.authentication.configurers.userdetails.DaoAuthenticationConfigurer;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.web.SecurityFilterChain;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig {
//
//    private static final String[] UNAUTH_END_POINTS = {"/actuator/**", "/ping", "/authentication/api/v1/user-access/add" };
//    private static final String[] USER_END_POINTS = {"/authentication/api/v1/user-access/get-role", "/authentication/api/v1/user-access/get" };
//    private static final String[] ADMIN_END_POINTS = {"/actuator/**", "/authentication/api/v1/user-access/remove" };
//
//    private final CustomUserDetailsService customUserDetailsService;
//
//    @Autowired
//    public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
//        this.customUserDetailsService = customUserDetailsService;
//    }
//
////    @Bean
////    public PasswordEncoder passwordEncoder() {
////        return new BCryptPasswordEncoder();
////    }
//
//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//        http
//                .csrf(csrf -> csrf.disable()) // Disable CSRF for simplicity
//                .authorizeHttpRequests(authorizeRequests -> authorizeRequests
//                        .requestMatchers(UNAUTH_END_POINTS).permitAll() // Allow unauthenticated access
//                        .requestMatchers(USER_END_POINTS).hasRole("USER") // Requires USER_ROLE
//                        .requestMatchers(ADMIN_END_POINTS).hasRole("ADMIN") // Requires ADMIN_ROLE
//                        .anyRequest().permitAll() // All other endpoints require authentication
//                )
//                .httpBasic(Customizer.withDefaults()); // Basic Authentication
//
//        return http.build();
//    }
//
////    @Bean
////    public UserDetailsService userDetailsService() {
////        return customUserDetailsService;
////    }
////
////    @Bean
////    public DaoAuthenticationConfigurer<AuthenticationManagerBuilder, UserDetailsService> configure(AuthenticationManagerBuilder auth) throws Exception {
////        return auth.userDetailsService(userDetailsService()).passwordEncoder(passwordEncoder());
////    }
//}
