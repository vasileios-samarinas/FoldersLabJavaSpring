package com.codeclan.example.FilesManager.controllers;

import com.codeclan.example.FilesManager.models.File;
import com.codeclan.example.FilesManager.models.User;
import com.codeclan.example.FilesManager.repositories.FileRepository;
import com.codeclan.example.FilesManager.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

public class UserController {

    @Autowired
    private UserRepository userRepository;

    @GetMapping(value = "/users")
    public ResponseEntity getAllUsers(){
        List<User> foundUsers = userRepository.findAll();
        return new ResponseEntity<>(foundUsers, HttpStatus.OK);
    }

    @GetMapping(value = "/users/{id}")
    public ResponseEntity getUser(@PathVariable Long id){
        return new ResponseEntity<>(userRepository.findById(id), HttpStatus.OK);
    }

    @PostMapping(value = "/users")
    public ResponseEntity postUser(@RequestBody User user){
        userRepository.save(user);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
