package com.prudvi.demo.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestDepositMoneyDTO {

	@NotNull
    private Integer amount;

    @NotNull
    private String bankCode;
}
