package com.bfz.usermanagementapi.role.core.application.port.out;

import com.bfz.usermanagementapi.role.core.domain.model.Role;

import java.util.List;
import java.util.Optional;

/**
 * @author bruferper
 */

public interface IRoleRepository {

    List<Role> findAll();
    Optional<Role> findById(Integer id);
    void create(Role role);
    void update(Role role);
    void deleteById(Integer id);
    boolean existsById(Integer id);

}
