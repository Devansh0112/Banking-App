package com.finproj.banking_application.dto;

public class BankResponse {
    private String responseCode;
    private String responseMessage;
    private AccountInfo accountInfo;

    BankResponse(String responseCode, String responseMessage, AccountInfo accountInfo) {
        this.responseCode = responseCode;
        this.responseMessage = responseMessage;
        this.accountInfo = accountInfo;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public AccountInfo getAccountInfo() {
        return accountInfo;
    }

    public static class Builder {
        private String responseCode;
        private String responseMessage;
        private AccountInfo accountInfo;

        public Builder responseCode(String responseCode) {
            this.responseCode = responseCode;
            return this;
        }

        public Builder responseMessage(String responseMessage) {
            this.responseMessage = responseMessage;
            return this;
        }

        public Builder accountInfo(AccountInfo accountInfo) {
            this.accountInfo = accountInfo;
            return this;
        }

        public BankResponse build() {
            return new BankResponse(responseCode, responseMessage, accountInfo);
        }
    }
}
