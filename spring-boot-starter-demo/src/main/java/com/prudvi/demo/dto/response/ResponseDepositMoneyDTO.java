package com.prudvi.demo.dto.response;


import com.prudvi.demo.statval.EnumActivity;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDepositMoneyDTO {

    private String username;
    private EnumActivity activity;
    private Integer balance;
    private Integer depositMoney;
}
