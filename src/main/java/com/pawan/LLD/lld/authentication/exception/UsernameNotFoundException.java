package com.pawan.LLD.lld.authentication.exception;

public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException() {
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
