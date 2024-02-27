package com.bfz.usermanagementapi.user.infraestructure.adapter.in.rest.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

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
    private MultipartFile photoFile;
    private String password;
    private Set<Integer> roleIds;

}
