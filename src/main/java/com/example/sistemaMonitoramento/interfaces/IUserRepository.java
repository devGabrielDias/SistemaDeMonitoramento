package com.example.sistemaMonitoramento.interfaces;



import com.example.sistemaMonitoramento.entities.User;

import java.util.List;

public interface IUserRepository {
    void adicionar(User user);

    void remover(int id);

    User buscarPorId(int id);

    List<User> buscarTodos();

    void atualizarRecepcionista(int id, User user);
}