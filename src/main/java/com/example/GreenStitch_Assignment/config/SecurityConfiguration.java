package com.example.GreenStitch_Assignment.config;

import com.example.GreenStitch_Assignment.jwt.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                .csrf((csrf) -> csrf.disable())
                .authorizeHttpRequests((authorizeHttpRequests) ->
                authorizeHttpRequests
                        .dispatcherTypeMatchers(HttpMethod.valueOf("/api/signup")).permitAll()
                        .dispatcherTypeMatchers(HttpMethod.valueOf("api/login")).permitAll()
                        .dispatcherTypeMatchers(HttpMethod.valueOf("api/hello")).authenticated().anyRequest().authenticated()
//                        .requestMatchers("/api/signup").permitAll()
//                        .requestMatchers("/api/login").permitAll()
//                        .requestMatchers("/api/hello").authenticated()
        )
                .addFilterBefore(jwtFilter(), UsernamePasswordAuthenticationFilter.class)
                .formLogin(withDefaults());
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public JwtFilter jwtFilter() {
        return new JwtFilter();
    }
}
