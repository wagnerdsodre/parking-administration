package com.labs.vacancys.repositories;

import com.labs.vacancys.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRespository extends JpaRepository<User, Long> {
}
