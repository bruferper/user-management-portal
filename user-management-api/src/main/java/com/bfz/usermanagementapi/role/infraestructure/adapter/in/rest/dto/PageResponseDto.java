package com.bfz.usermanagementapi.role.infraestructure.adapter.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author bruferper
 */
@Data
@AllArgsConstructor
@Builder
public class PageResponseDto<T> {

    private T content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;

}
