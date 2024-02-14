package com.bfz.usermanagementapi.common.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;

/**
 * @author bruferper
 */

@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public record ApiResponseDto<T>(
        boolean ok,
        String message,
        T body
) { }
