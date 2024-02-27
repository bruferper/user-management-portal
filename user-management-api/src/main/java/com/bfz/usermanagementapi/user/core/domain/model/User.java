package com.bfz.usermanagementapi.user.core.domain.model;

import com.bfz.usermanagementapi.role.core.domain.model.Role;
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
    private String photoName;
    private String photoUrl;
    private String password;

    private Set<Role> roles;

}
