package com.example.chothuenha.service;

import com.example.chothuenha.model.User;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findByEmail(String email);

    Boolean existsByEmail(String email);

    User findById(Long id);

    void saveUser(User user);

    void deleteUser(Long id);
}
