package com.demo.springboot.springsecurity.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.springboot.springsecurity.entities.User;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserName(String userName);
}