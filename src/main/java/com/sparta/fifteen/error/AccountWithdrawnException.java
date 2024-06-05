package com.sparta.fifteen.error;

public class AccountWithdrawnException extends RuntimeException {
    public AccountWithdrawnException(String message) {
        super(message);
    }
}
