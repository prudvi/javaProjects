package com.prudvi.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prudvi.demo.entity.BankBalance;

public interface IBankBalanceDAO extends JpaRepository<BankBalance, Long> {

    BankBalance findByCode(String code);
}
