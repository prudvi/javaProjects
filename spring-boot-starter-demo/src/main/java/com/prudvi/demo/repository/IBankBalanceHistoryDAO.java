package com.prudvi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prudvi.demo.entity.BankBalanceHistory;

public interface IBankBalanceHistoryDAO extends JpaRepository<BankBalanceHistory, Long> {
}
