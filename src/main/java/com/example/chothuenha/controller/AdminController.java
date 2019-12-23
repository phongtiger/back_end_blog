package com.example.chothuenha.controller;

import com.example.chothuenha.model.Category;
import com.example.chothuenha.service.CategoryService;
import com.example.chothuenha.service.NoteService;
import com.example.chothuenha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<?> createCategory(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/getAllCategory")
    public ResponseEntity<Iterable<Category>> getAllCategory(){
        return new ResponseEntity<>(categoryService.findAll(),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/editCategory")
    public ResponseEntity<?> editFormCategory(@RequestParam Long id){
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/editCategory")
    public ResponseEntity<?> editCategory(@RequestBody Category category){
        categoryService.save(category);
        return new ResponseEntity<>(HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/deleteFormCategory")
    public ResponseEntity<?> deleteFormCategory(@RequestParam Long id){
        return new ResponseEntity<>(categoryService.findById(id),HttpStatus.OK);
    }
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/deleteCategory")
    public ResponseEntity<?> deleteCategory(@RequestBody Long id){
        try {
            categoryService.delete(id);
        } catch (Exception e){
            System.out.println("Không xóa được do còn row id với cột khác");
            return new ResponseEntity<>("Không xóa được. Bạn phải xóa hết bài Note có category này",HttpStatus.BAD_REQUEST);}
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
