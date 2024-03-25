package com.bfz.usermanagementapi.role.core.application.port.out;

import com.bfz.usermanagementapi.role.core.domain.model.Page;
import com.bfz.usermanagementapi.role.core.domain.model.Role;

import java.util.List;
import java.util.Optional;

/**
 * @author bruferper
 */

public interface IRoleRepository {

    Page<List<Role>> findAll(int pageNo, int pageSize);
    Optional<Role> findById(Integer id);
    void create(Role role);
    void update(Role role);
    void deleteById(Integer id);
    boolean existsById(Integer id);

}
