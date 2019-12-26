package com.example.chothuenha.controller;

import com.example.chothuenha.message.request.FriendForm;
import com.example.chothuenha.message.request.MessageForm;
import com.example.chothuenha.message.request.NoteForm;
import com.example.chothuenha.model.Message;
import com.example.chothuenha.model.Note;
import com.example.chothuenha.model.User;
import com.example.chothuenha.security.services.UserDetailsServiceImpl;
import com.example.chothuenha.service.MessageService;
import com.example.chothuenha.service.NoteService;
import com.example.chothuenha.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    private NoteService noteService;

    @Autowired
    private UserService userService;

    @Autowired
    private UserDetailsServiceImpl userDetailsService;

    @Autowired
    private MessageService messageService;

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
        originNote.setUser(userService.findById(note.getUser_id()));
        noteService.save(originNote);
        return new ResponseEntity<>(HttpStatus.OK);
        }
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/friendRequest")
    public ResponseEntity<?> requestFriend(@RequestBody FriendForm friendForm){
        Set<User> friends = new HashSet<>();
        User user = userService.findById(friendForm.getUser_id());
        User friend = userService.findById(friendForm.getFriend_id());
        if (user != null && friend != null) {
            friends.add(friend);
            user.setFriends(friends);
            userService.saveUser(user);
            return new ResponseEntity<>( HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    @PostMapping("/sendMessage")
    public ResponseEntity<?> sendMessage(@RequestBody MessageForm messageForm){
        User user = userService.findById(messageForm.getUser());
        User friend = userService.findById(messageForm.getFriend());
        Set<User> friendsUser = user.getFriends();
        Set<User> friendsFriend = friend.getFriends();
        Message message = new Message();
        message.setUser(user);
        message.setFriend(friend);
        message.setContent(messageForm.getContent());
        if(friendsUser.contains(friend)&&friendsFriend.contains(user)){
            messageService.save(message);
            return new ResponseEntity<>( HttpStatus.OK);
        } else {
            return new ResponseEntity<>( HttpStatus.NOT_FOUND);
        }
    }
//    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
//    @PostMapping("/yourMessage/send")
//    public ResponseEntity<?> yourMessage(@RequestBody MessageForm messageForm){
//
//    }
}
