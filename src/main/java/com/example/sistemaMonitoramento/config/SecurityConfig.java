package com.example.sistemaMonitoramento.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.CsrfDsl;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import javax.sql.DataSource;

// @Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public UserDetailsManager userDetailsManager(DataSource dataSource) {
        JdbcUserDetailsManager jdbcUserDetailsManager = new JdbcUserDetailsManager(dataSource);

        jdbcUserDetailsManager.setUsersByUsernameQuery("SELECT username, password, enabled FROM user WHERE username = ?");
        jdbcUserDetailsManager.setAuthoritiesByUsernameQuery(
                "SELECT u.username, r.role FROM user u INNER JOIN role r ON u.id = r.user_id WHERE u.username = ?"
        );

        return jdbcUserDetailsManager;


    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(auth -> {
                    auth
                            .requestMatchers(HttpMethod.GET, "/consulta/**").hasAnyRole("MEDICO", "PACIENTE")
                            .requestMatchers(HttpMethod.POST, "/consulta/**").hasRole("RECEPCIONISTA")
                            .requestMatchers(HttpMethod.GET, "/monitoramento/**").hasRole("MEDICO")
                            .requestMatchers(HttpMethod.GET, "/paciente/**").hasRole("PACIENTE")
                            .requestMatchers(HttpMethod.POST, "/paciente/**").hasRole("RECEPCIONISTA")
                            .anyRequest().authenticated(); // Todas as outras rotas requerem autenticação
                })
                .httpBasic(Customizer.withDefaults());
                http.csrf(csrf -> csrf.disable()); // Desabilitando CSRF para simplificação de teste

        return http.build();
    }
}