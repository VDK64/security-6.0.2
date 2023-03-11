package com.example.basicAuth.config.security;

import com.example.basicAuth.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import static com.example.basicAuth.config.security.UserPermission.COURSE_READ;
import static com.example.basicAuth.config.security.UserPermission.COURSE_WRITE;
import static com.example.basicAuth.config.security.UserRole.ADMIN;
import static com.example.basicAuth.config.security.UserRole.USER;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final UserRepository userRepository;

    @Bean
    public UserDetailsService userDetailsService() {
        return username -> userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User " + username + " not found"));
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers("/api/v1/main/**").permitAll()
                .requestMatchers("/api/v1/user/**").hasRole(USER.name())
                .requestMatchers("/api/v1/admin/**").hasRole(ADMIN.name())
                .requestMatchers(HttpMethod.POST, "/api/v1/course/**").hasAuthority(COURSE_WRITE.getPermission())
                .requestMatchers(HttpMethod.PUT, "/api/v1/course/**").hasAuthority(COURSE_WRITE.getPermission())
                .requestMatchers(HttpMethod.DELETE, "/api/v1/course/**").hasAuthority(COURSE_WRITE.getPermission())
                .requestMatchers(HttpMethod.GET, "/api/v1/course/**").hasAnyAuthority(COURSE_READ.getPermission(), COURSE_WRITE.getPermission())
                .requestMatchers("/api/v1/course/**").hasAnyRole(ADMIN.name(), USER.name())
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

}
