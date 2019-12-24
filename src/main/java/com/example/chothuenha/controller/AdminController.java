package com.example.chothuenha.controller;

import com.example.chothuenha.message.request.CategoryForm;
import com.example.chothuenha.model.Category;
import com.example.chothuenha.service.CategoryService;
import com.example.chothuenha.service.NoteService;
import com.example.chothuenha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/admin")
public class AdminController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/createCategory")
    public ResponseEntity<?> createCategory(@Valid @RequestBody CategoryForm category, BindingResult result){
        if(result.hasErrors()){
            System.out.println("error validate category form");
            return new ResponseEntity<>("error validate category form",HttpStatus.NOT_FOUND);
        } else {
            Category originCategory = new Category();
            originCategory.setName(category.getName());
            categoryService.save(originCategory);
            return new ResponseEntity<>("create Category success",HttpStatus.OK);
        }
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllCategory")
    public ResponseEntity<Iterable<Category>> getAllCategory(){
        return new ResponseEntity<>(categoryService.findAll(),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/editCategory/{id}")
    public ResponseEntity<?> editFormCategory(@PathVariable("id") Long id){
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/editCategory")
    public ResponseEntity<?> editCategory(@RequestBody CategoryForm category){
        Category originCategory = new Category();
        originCategory.setId(category.getId());
        originCategory.setName(category.getName());
        categoryService.save(originCategory);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/deleteCategory/{id}")
    public ResponseEntity<?> deleteFormCategory(@PathVariable Long id){
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/deleteCategory/{id}")
    public ResponseEntity<?> deleteCategory(@PathVariable Long id){
        try {
            categoryService.delete(id);
            return new ResponseEntity<>("delete success ",HttpStatus.OK);
        } catch (Exception e){
            System.out.println("Không xóa được do còn row id với cột khác");
            return new ResponseEntity<>(
                    "Không xóa được. Bạn phải xóa hết bài Note có category này",
                    HttpStatus.NOT_FOUND);
        }
    }
}
