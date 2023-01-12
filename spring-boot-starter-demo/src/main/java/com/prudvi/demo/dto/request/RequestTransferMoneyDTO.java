package com.prudvi.demo.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RequestTransferMoneyDTO {
	@NotNull
    private String transferTo;

    @NotNull
    private Integer amount;

    @NotNull
    private String bankCodeTo;

    @NotNull
    private String bankCodeFrom;
}
