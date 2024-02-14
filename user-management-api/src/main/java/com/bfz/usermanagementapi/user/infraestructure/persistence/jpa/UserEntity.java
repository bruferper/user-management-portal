package com.bfz.usermanagementapi.user.infraestructure.persistence.jpa;

import com.bfz.usermanagementapi.role.domain.model.Role;
import com.bfz.usermanagementapi.role.infraestructure.persistence.jpa.RoleEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

/**
 * @author bruferper
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;
    @Column(nullable = false, length = 50)
    private String firstName;
    @Column(nullable = false, length = 50)
    private String lastName;
    @Column(nullable = false, length = 100)
    private String email;
    private String photo;
    private String password;

    @ManyToMany
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;

}
