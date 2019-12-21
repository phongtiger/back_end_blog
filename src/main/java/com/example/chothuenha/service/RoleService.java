package com.example.chothuenha.service;

import com.example.chothuenha.model.Role;
import com.example.chothuenha.model.RoleName;

public interface RoleService {
    Role findByName(RoleName roleName);

    void save(Role role);
}
