package com.bfz.usermanagementapi.user.infraestructure.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author bruferper
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserRequestDto {

    private String firstName;
    private String lastName;
    private String email;
    private String photo;
    private String password;
    private Set<Integer> roleIds;

}
