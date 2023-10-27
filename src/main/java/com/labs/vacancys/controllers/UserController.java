package com.labs.vacancys.controllers;

import com.labs.vacancys.entities.User;
import com.labs.vacancys.services.UserServices;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> list = userServices.getAllUsers();
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody User user) {
        User obj = userServices.CreateUser(user);
        return ResponseEntity.status(HttpStatus.CREATED).body(obj);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable Long id) {
        User user = userServices.findByIDUser(id);
        return ResponseEntity.ok().body(user);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@PathVariable Long id, @RequestBody User user) {
        user = userServices.updateUser(id, user);
        return ResponseEntity.ok().body(user);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<User> ChangeUserPassword(@PathVariable Long id, @RequestBody User u) {
        User user = userServices.UpdatePassword(id, u.getPassword());
        return ResponseEntity.ok(user);
    }
}

