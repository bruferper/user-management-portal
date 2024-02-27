package com.bfz.usermanagementapi.user.infraestructure.adapter.in.rest.dto;

import com.bfz.usermanagementapi.role.infraestructure.adapter.in.rest.dto.RoleResponseDto;
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
    private String photoUrl;
    private List<RoleResponseDto> roles;

}
