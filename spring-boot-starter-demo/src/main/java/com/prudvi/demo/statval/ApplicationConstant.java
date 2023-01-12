package com.prudvi.demo.statval;

public interface ApplicationConstant {

    interface ContextPath {
        String V1_USER_BALANCE = "/v1/user-balance";
        String V1_AUTH = "/v1/auth";
    }

    interface Path {

        interface UserBalance {
            String DEPOSIT_MONEY = "deposit-money";
            String TRANSFER_MONEY = "transfer-money";
        }
    }
}
