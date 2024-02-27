package com.bfz.usermanagementapi.common.exception;

import com.bfz.usermanagementapi.common.dto.ApiResponseDto;
import com.bfz.usermanagementapi.role.core.domain.exception.RoleNotFoundException;
import com.bfz.usermanagementapi.user.core.domain.exception.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author bruferper
 */

@ControllerAdvice
@Slf4j
public class AppExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiResponseDto<Void>> onUserNotFoundException(UserNotFoundException ex) {
        return ResponseEntity.badRequest().body(ApiResponseDto.<Void>builder().ok(false).message(ex.getMessage()).build());
    }

    @ExceptionHandler(RoleNotFoundException.class)
    public ResponseEntity<ApiResponseDto<Void>> onRoleNotFoundException(RoleNotFoundException ex) {
        return ResponseEntity.badRequest().body(ApiResponseDto.<Void>builder().ok(false).message(ex.getMessage()).build());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiResponseDto<Void>> onGeneralException(Exception ex) {
        log.error(ex.getMessage());
        return ResponseEntity.internalServerError().body(ApiResponseDto.<Void>builder().ok(false).message("General error. Please check the logs.").build());
    }

}
