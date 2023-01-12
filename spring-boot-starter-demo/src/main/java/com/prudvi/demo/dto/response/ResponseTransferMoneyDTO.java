package com.prudvi.demo.dto.response;

import lombok.*;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTransferMoneyDTO {

    private String transferFrom;
    private String transferTo;
    private Integer amount;

}
