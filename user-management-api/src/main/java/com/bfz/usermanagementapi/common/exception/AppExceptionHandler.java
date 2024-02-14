package com.bfz.usermanagementapi.common.exception;

import com.bfz.usermanagementapi.common.dto.ApiResponseDto;
import com.bfz.usermanagementapi.role.domain.exception.RoleNotFoundException;
import com.bfz.usermanagementapi.user.domain.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author bruferper
 */

@ControllerAdvice
public class AppExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponseDto<Void>> onUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.badRequest().body(ApiResponseDto.<Void>builder().ok(false).message(ex.getMessage()).build());
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ApiResponseDto<Void>> onRoleNotFoundException(RoleNotFoundException ex) {
        return ResponseEntity.badRequest().body(ApiResponseDto.<Void>builder().ok(false).message(ex.getMessage()).build());
    }

}
