package com.example.chothuenha.repository;

import com.example.chothuenha.model.Role;
import com.example.chothuenha.model.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}