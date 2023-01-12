package com.prudvi.demo.dto.request;

import javax.servlet.http.HttpServletRequest;

import com.prudvi.demo.statval.ApplicationConstant.Path.UserBalance;
import com.prudvi.demo.statval.EnumActivity;
import com.prudvi.demo.statval.EnumsType;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestProsesTransactionDTO {
	private UserBalance userBalance;
    private BankBalance bankBalance;
    private Integer amount;
    private EnumsType type;
    private EnumActivity activity;
    private String author;
    private HttpServletRequest httpServletRequest;
}
