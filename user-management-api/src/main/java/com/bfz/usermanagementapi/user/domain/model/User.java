package com.bfz.usermanagementapi.user.domain.model;

import com.bfz.usermanagementapi.role.domain.model.Role;
import lombok.*;

import java.util.Set;

/**
 * @author bruferper
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class User {

    @EqualsAndHashCode.Include
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String photo;
    private String password;

    private Set<Role> roles;

}
