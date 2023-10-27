package com.labs.vacancys.services;

import com.labs.vacancys.entities.User;
import com.labs.vacancys.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServices {

    @Autowired
    private UserRepository userRepository;

    @Transactional
    public User CreateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User findByIDUser(Long id) {
        return userRepository.findById(id).orElseThrow(
                //temp
                () -> new RuntimeException("User not found!")
        );
    }

    @Transactional
    public User updateUser(Long id, User u) {
        User entity = userRepository.getReferenceById(id);
        entity.setUsername(u.getUsername());
        entity.setRole(u.getRole());
        entity.setPassword(u.getPassword());
        return userRepository.save(entity);
    }

    @Transactional
    public User UpdatePassword(Long id, String password) {
        User user = findByIDUser(id);
        user.setPassword(password);
        return user;
    }
}
