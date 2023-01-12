package com.prudvi.demo.service.impl;

import java.util.Objects;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.prudvi.demo.dto.request.RequestDepositMoneyDTO;
import com.prudvi.demo.dto.request.RequestProsesTransactionDTO;
import com.prudvi.demo.dto.request.RequestTransferMoneyDTO;
import com.prudvi.demo.dto.response.ResponseTransferMoneyDTO;
import com.prudvi.demo.entity.BankBalance;
import com.prudvi.demo.entity.BankBalanceHistory;
import com.prudvi.demo.entity.UserBalance;
import com.prudvi.demo.entity.UserBalanceHistory;
import com.prudvi.demo.exception.ServiceException;
import com.prudvi.demo.repository.IBankBalanceDAO;
import com.prudvi.demo.repository.IBankBalanceHistoryDAO;
import com.prudvi.demo.repository.IUserBalanceDAO;
import com.prudvi.demo.repository.IUserBalanceHistoryDAO;
import com.prudvi.demo.service.IUserBalanceService;
import com.prudvi.demo.statval.EnumActivity;
import com.prudvi.demo.statval.EnumsType;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserBalanceServiceImpl implements IUserBalanceService {

    private final IUserBalanceDAO iUserBalanceDAO;
    private final IUserBalanceHistoryDAO iUserBalanceHistoryDAO;
    private final IBankBalanceDAO iBankBalanceDAO;
    private final IBankBalanceHistoryDAO iBankBalanceHistoryDAO;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public UserBalance depositMoney(RequestDepositMoneyDTO requestDepositMoneyDTO, String username, HttpServletRequest request) throws Exception {
        UserBalance userBalance = iUserBalanceDAO.findByUser_Username(username);
        BankBalance bankBalance = iBankBalanceDAO.findByCode(requestDepositMoneyDTO.getBankCode());

        if (Objects.isNull(bankBalance)) {
            throw new ServiceException("Bank balance not found");
        }

        if (Objects.isNull(userBalance)) {
            throw new ServiceException("User balance not found");
        }

        return prosesTransaction(RequestProsesTransactionDTO.builder()
                .userBalance(userBalance)
                .bankBalance(bankBalance)
                .type(EnumsType.DEBIT)
                .httpServletRequest(request)
                .author(username)
                .amount(requestDepositMoneyDTO.getAmount())
                .activity(EnumActivity.DEPOSIT_MONEY)
                .build());
    }

    @Override
    public ResponseTransferMoneyDTO transferMoney(RequestTransferMoneyDTO requestTransferMoneyDTO, String username, HttpServletRequest request) throws Exception {
        UserBalance userBalanceFrom = iUserBalanceDAO.findByUser_Username(username);
        if (Objects.isNull(userBalanceFrom)) throw new ServiceException("User balance from not found");

        if (username.equals(requestTransferMoneyDTO.getTransferTo())) throw new ServiceException("Bad request, User transfer is wrong");

        UserBalance userBalanceTo = iUserBalanceDAO.findByUser_Username(requestTransferMoneyDTO.getTransferTo());
        if (Objects.isNull(userBalanceTo)) throw new ServiceException("User balance to not found");

        BankBalance bankBalanceFrom = iBankBalanceDAO.findByCode(requestTransferMoneyDTO.getBankCodeFrom());
        if (Objects.isNull(bankBalanceFrom)) throw new ServiceException("Bank balance from not found");

        BankBalance bankBalanceTo = iBankBalanceDAO.findByCode(requestTransferMoneyDTO.getBankCodeTo());
        if (Objects.isNull(bankBalanceTo)) throw new ServiceException("Bank balance to not found");

        if (requestTransferMoneyDTO.getAmount() > userBalanceFrom.getBalanceAchieve()) throw new ServiceException("Bank balance is not enough");

        prosesTransaction(RequestProsesTransactionDTO.builder()
                .userBalance(userBalanceFrom)
                .bankBalance(bankBalanceFrom)
                .type(EType.CREDIT)
                .httpServletRequest(request)
                .author(username)
                .amount(requestTransferMoneyDTO.getAmount())
                .activity(EActivity.TRANSFER_MONEY)
                .build());

        prosesTransaction(RequestProsesTransactionDTO.builder()
                .userBalance(userBalanceTo)
                .bankBalance(bankBalanceTo)
                .type(EType.DEBIT)
                .httpServletRequest(request)
                .author(userBalanceTo.getUser().getUsername())
                .amount(requestTransferMoneyDTO.getAmount())
                .activity(EActivity.TRANSFER_MONEY)
                .build());

        return ResponseTransferMoneyDTO.builder()
                .transferFrom(userBalanceFrom.getUser().getUsername())
                .transferTo(userBalanceTo.getUser().getUsername())
                .amount(requestTransferMoneyDTO.getAmount())
                .build();
    }

    private synchronized UserBalance prosesTransaction(RequestProsesTransactionDTO request){
        int amountUserBalance;
        int amountBankBalance;
        UserBalance userBalance = request.getUserBalance();
        BankBalance bankBalance = request.getBankBalance();

        if (request.getType().equals(EType.DEBIT)) {
            amountUserBalance = request.getUserBalance().getBalanceAchieve() + request.getAmount();
            amountBankBalance = bankBalance.getBalanceAchieve() + request.getAmount();
        } else {
            amountUserBalance = request.getUserBalance().getBalanceAchieve() - request.getAmount();
            amountBankBalance = bankBalance.getBalanceAchieve() - request.getAmount();
        }

        UserBalanceHistory userBalanceHistory = UserBalanceHistory.builder()
                .userBalance(userBalance)
                .balanceBefore(userBalance.getBalanceAchieve())
                .balanceAfter(amountUserBalance)
                .activity(request.getActivity())
                .type(request.getType())
                .ip(request.getHttpServletRequest().getLocalAddr())
                .userAgent(request.getHttpServletRequest().getHeader("user-agent"))
                .author(request.getAuthor())
                .build();
        iUserBalanceHistoryDAO.save(userBalanceHistory);

        userBalance.setBalanceAchieve(amountUserBalance);
        userBalance.setBalance(String.valueOf(amountUserBalance));
        iUserBalanceDAO.save(userBalance);

        BankBalanceHistory bankBalanceHistory = BankBalanceHistory.builder()
                .bankBalance(bankBalance)
                .balanceBefore(userBalance.getBalanceAchieve())
                .balanceAfter(amountBankBalance)
                .activity(request.getActivity())
                .type(request.getType())
                .ip(request.getHttpServletRequest().getLocalAddr())
                .userAgent(request.getHttpServletRequest().getHeader("user-agent"))
                .author(request.getAuthor())
                .build();
        iBankBalanceHistoryDAO.save(bankBalanceHistory);

        bankBalance.setBalanceAchieve(amountBankBalance);
        bankBalance.setBalance(amountBankBalance);
        iBankBalanceDAO.save(bankBalance);

        return  userBalance;
    }

}
