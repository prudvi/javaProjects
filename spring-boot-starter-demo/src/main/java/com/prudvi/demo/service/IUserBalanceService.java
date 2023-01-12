package com.prudvi.demo.service;


import javax.servlet.http.HttpServletRequest;

import org.springframework.transaction.annotation.Transactional;

import com.prudvi.demo.dto.request.RequestDepositMoneyDTO;
import com.prudvi.demo.dto.request.RequestTransferMoneyDTO;
import com.prudvi.demo.dto.response.ResponseTransferMoneyDTO;
import com.prudvi.demo.entity.UserBalance;

public interface IUserBalanceService {

    @Transactional
    UserBalance depositMoney(RequestDepositMoneyDTO requestDepositMoneyDTO, String username, HttpServletRequest request) throws Exception;

    ResponseTransferMoneyDTO transferMoney(RequestTransferMoneyDTO requestTransferMoneyDTO, String username, HttpServletRequest request) throws Exception;
}
