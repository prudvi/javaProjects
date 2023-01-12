package com.prudvi.demo.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.privyid.pretest.privyidpretestbackendenginer.statval.IApplicationConstant;
import com.prudvi.demo.dto.request.RequestDepositMoneyDTO;
import com.prudvi.demo.dto.request.RequestTransferMoneyDTO;
import com.prudvi.demo.dto.response.ResponseDepositMoneyDTO;
import com.prudvi.demo.dto.response.ResponseTransferMoneyDTO;

import jakarta.validation.Valid;
@RequestMapping(ApplicationConstant.ContextPath.V1_USER_BALANCE)
public interface UserBalanceEndPointInterface {
	@PostMapping(ApplicationConstant.Path.UserBalance.DEPOSIT_MONEY)
    ResponseEntity<ResponseDepositMoneyDTO> depositMoney(@Valid @RequestBody RequestDepositMoneyDTO requestDepositMoneyDTO,
                                                         Authentication authentication,
                                                         HttpServletRequest request) throws Exception;

    @PostMapping(ApplicationConstant.Path.UserBalance.TRANSFER_MONEY)
    ResponseEntity<ResponseTransferMoneyDTO> transferMoney(@Valid @RequestBody RequestTransferMoneyDTO requestDepositMoneyDTO,
                                                           Authentication authentication,
                                                           HttpServletRequest request) throws Exception;
}
