package com.prudvi.demo.dto.request;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestLoginDTO {
	private String username;
    private String password;
}
