package com.bfz.usermanagementapi.user.infraestructure.dto;

import com.bfz.usermanagementapi.role.infraestructure.dto.RoleResponseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author bruferper
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserResponseDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String photo;
    private List<RoleResponseDto> roles;

}
