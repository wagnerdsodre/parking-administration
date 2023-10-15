package com.labs.vacancys.repositories;

import com.labs.vacancys.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
