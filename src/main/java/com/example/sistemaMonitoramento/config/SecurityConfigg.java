/*package com.example.sistemaMonitoramento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

@Configuration
public class SecurityConfig {

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT email, senha, enabled FROM user where email = ?");

        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery("select email, role from user inner join role on user.id = role.user_id where email = ?");

        return jdbcUserDetailsManager;
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests(configurer -> {
            configurer
                    .requestMatchers(HttpMethod.GET, "/api/teachers/").hasRole("MEDICO")
                    .requestMatchers(HttpMethod.GET, "/api/teachers/**").hasRole("PACIENTE")
                    .requestMatchers(HttpMethod.GET, "/api/teachers/**").hasRole("RECEPCIONISTA")
                    .requestMatchers(HttpMethod.POST, "/api/teachers/").hasRole("COORDINATOR")
                    .requestMatchers(HttpMethod.PUT, "/api/teachers/**").hasRole("COORDINATOR")
                    .requestMatchers(HttpMethod.DELETE, "/api/teachers/**").hasRole("ADMIN")
                    .requestMatchers("/api/users/**").permitAll();
        });

        httpSecurity.httpBasic(Customizer.withDefaults());

        httpSecurity.csrf(csrf -> csrf.disable());

        return httpSecurity.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}*/