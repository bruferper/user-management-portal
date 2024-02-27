package com.bfz.usermanagementapi.user.core.domain.exception;

/**
 * @author bruferper
 */

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String message) {
        super(message);
    }

}
