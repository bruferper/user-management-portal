package com.bfz.usermanagementapi.role.core.domain.model;

import lombok.Builder;
import lombok.Getter;

/**
 * @author bruferper
 */

@Getter
@Builder
public class Page<T> {
    private T content;
    private int pageNo;
    private int pageSize;
    private long totalElements;
    private int totalPages;
}
