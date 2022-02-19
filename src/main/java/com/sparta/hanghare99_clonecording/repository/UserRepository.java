package com.sparta.hanghare99_clonecording.repository;

import com.sparta.hanghare99_clonecording.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

<<<<<<< HEAD
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
=======
public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByEmail(String email);
    Optional<User> findByUserId(String userId);
>>>>>>> ca598ee6502bc698c525c9faaaaf7cca4159b0b9
}
