package com.pawan.LLD.lld.authentication.exception;

/**
 * @author Pawan Saini
 * Created on 11/09/24.
 */
public class UsernameNotFoundException extends RuntimeException {

    public UsernameNotFoundException() {
    }

    public UsernameNotFoundException(String message) {
        super(message);
    }
}
