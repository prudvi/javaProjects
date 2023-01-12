package com.prudvi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prudvi.demo.entity.UserBalance;

public interface IUserBalanceDAO extends JpaRepository<UserBalance, Long> {

    UserBalance findByUser_Username(String username);
}
