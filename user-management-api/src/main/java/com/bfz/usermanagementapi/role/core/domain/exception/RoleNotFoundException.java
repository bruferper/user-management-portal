package com.bfz.usermanagementapi.role.core.domain.exception;

/**
 * @author bruferper
 */

public class RoleNotFoundException extends RuntimeException {

    public RoleNotFoundException(String message) {
        super(message);
    }

}
