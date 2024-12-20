package com.example.sistemaMonitoramento.repositories;

import com.example.sistemaMonitoramento.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}