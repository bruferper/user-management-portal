package com.bfz.usermanagementapi.role.infraestructure.adapter.out.persistence.jpa;

import jakarta.persistence.*;
import lombok.*;

/**
 * @author bruferper
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@Table(name = "roles")
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Integer id;
    @Column(nullable = false, length = 50)
    private String name;

}
