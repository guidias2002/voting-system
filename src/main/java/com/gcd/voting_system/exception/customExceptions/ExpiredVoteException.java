package com.gcd.voting_system.exception.customExceptions;

public class ExpiredVoteException extends RuntimeException {

    public ExpiredVoteException(String message) {
        super(message);
    }
}
