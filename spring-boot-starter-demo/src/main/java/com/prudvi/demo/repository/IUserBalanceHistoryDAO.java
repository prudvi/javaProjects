package com.prudvi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prudvi.demo.entity.UserBalanceHistory;

public interface IUserBalanceHistoryDAO extends JpaRepository<UserBalanceHistory, Long> {
}
