package com.bfz.usermanagementapi.role.domain.exception;

/**
 * @author bruferper
 */

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(String message) {
        super(message);
    }

}
