package com.example.prep_pilot.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long id) {

        super("해당 유저 없음. id=" + id);
    }
}
