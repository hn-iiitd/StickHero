package com.iiitd.stickhero;

public class UserNameAlreadyExistsException extends Exception {
    public UserNameAlreadyExistsException(String msg) {
        super(msg);
    }
}
