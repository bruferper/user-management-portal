package com.bfz.usermanagementapi.role.core.domain.model;

import lombok.*;

/**
 * @author bruferper
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Role {

    @EqualsAndHashCode.Include
    private Integer id;
    private String name;

}
