package com.example.chothuenha.controller;

import com.example.chothuenha.message.request.NoteForm;
import com.example.chothuenha.model.Note;
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
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private NoteService noteService;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private UserService userService;

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/createNote")
    public ResponseEntity<?> createNote(@Valid @RequestBody NoteForm note, BindingResult result){
        if(result.hasErrors()){
            System.out.println(" Lỗi validate");
            return new ResponseEntity<>("Error validate",HttpStatus.NOT_FOUND);
        } else {
        Note originNote = new Note();
        originNote.setName(note.getName());
        originNote.setContent(note.getContent());
        originNote.setUrl(note.getUrl());
        originNote.setCategory(categoryService.findById(note.getCategory_id()));
        originNote.setUser(userService.findById(note.getUser_id()));
        noteService.save(originNote);
        return new ResponseEntity<>(HttpStatus.OK);
        }
    }
}
