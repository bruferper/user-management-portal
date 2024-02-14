package com.bfz.usermanagementapi.role.infraestructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author bruferper
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RoleResponseDto {

    private Integer id;
    private String name;

}
