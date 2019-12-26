package com.example.chothuenha.confign;

import com.example.chothuenha.model.Role;
import com.example.chothuenha.model.RoleName;
import com.example.chothuenha.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private RoleService roleService;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        for (RoleName roleName : RoleName.values()) {
            if (roleService.findByName(roleName) == null) {
                roleService.save(new Role(roleName));
            }
        }
    }
}
