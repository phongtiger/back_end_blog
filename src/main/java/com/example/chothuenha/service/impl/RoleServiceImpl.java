package com.example.chothuenha.service.impl;

import com.example.chothuenha.model.Role;
import com.example.chothuenha.model.RoleName;
import com.example.chothuenha.repository.RoleRepository;
import com.example.chothuenha.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findByName(RoleName roleName) {

        return roleRepository.findByName(roleName).isPresent()?roleRepository.findByName(roleName).get():null;
    }

    @Override
    public void save(Role role) {
        roleRepository.save(role);
    }
}
