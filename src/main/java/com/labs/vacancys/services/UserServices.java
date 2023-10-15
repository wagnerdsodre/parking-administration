package com.labs.vacancys.services;

import com.labs.vacancys.entities.User;
import com.labs.vacancys.repositories.UserRepository;
import io.micrometer.observation.Observation;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserServices {

    private final UserRepository userRepository;

    @Transactional
    public User CreateUser(User user) {
        return userRepository.save(user);
    }

    @Transactional
    public User findByIDUser(Long  id){
     return userRepository.findById(id).orElseThrow(
             //temp
           () -> new RuntimeException("User not found!")
        );
    }
}
