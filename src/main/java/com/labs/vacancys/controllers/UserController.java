package com.labs.vacancys.controllers;

import com.labs.vacancys.entities.User;
import com.labs.vacancys.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {
    private final UserServices userServices;
    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user){
        User obj = userServices.CreateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id){
     User user = userServices.findByIDUser(id);
     return ResponseEntity.ok().body(user);
    }
}
