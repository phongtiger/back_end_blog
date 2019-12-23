package com.example.chothuenha.confign;

import com.example.chothuenha.model.Category;
import com.example.chothuenha.model.CategoryName;
import com.example.chothuenha.model.Role;
import com.example.chothuenha.model.RoleName;
import com.example.chothuenha.service.CategoryService;
import com.example.chothuenha.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DataSeedingListener implements ApplicationListener<ContextRefreshedEvent> {
    @Autowired
    private RoleService roleService;
    @Autowired
    private CategoryService categoryService;
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        for (RoleName roleName : RoleName.values()) {
            if (roleService.findByName(roleName) == null) {
                roleService.save(new Role(roleName));
            }
        }
        for (CategoryName categoryName: CategoryName.values()){
            if (categoryService.findByName(categoryName.toString()) == null){
                categoryService.save(new Category(categoryName.toString()));
            }
        }
    }
}
