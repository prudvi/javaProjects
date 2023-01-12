package com.prudvi.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prudvi.demo.entity.User;

public interface IUserDAO extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByUsernameAndStatusLoginTrue(String username);
}
