package com.finproj.banking_application.dto;

import java.math.BigDecimal;

public class AccountInfo {
    private String accountName;
    private BigDecimal accountBalance;
    private String accountNumber;

    private AccountInfo(String accountName, BigDecimal accountBalance, String accountNumber) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
    }

    public String getAccountName() {
        return accountName;
    }

    public BigDecimal getAccountBalance() {
        return accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    // Builder Class
    public static class Builder {
        private String accountName;
        private BigDecimal accountBalance;
        private String accountNumber;

        // Default constructor for Builder
        public Builder() {
        }

        // Setter methods for Builder
        public Builder accountName(String accountName) {
            this.accountName = accountName;
            return this;
        }

        public Builder accountBalance(BigDecimal accountBalance) {
            this.accountBalance = accountBalance;
            return this;
        }

        public Builder accountNumber(String accountNumber) {
            this.accountNumber = accountNumber;
            return this;
        }

        public AccountInfo build() {
            return new AccountInfo(accountName, accountBalance, accountNumber);
        }
    }
}
