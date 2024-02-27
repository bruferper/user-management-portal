package com.bfz.usermanagementapi.role.core.application.port.in.usecase;

import com.bfz.usermanagementapi.role.core.domain.model.Role;

import java.util.List;

/**
 * @author bruferper
 */

public interface IRoleService {

    List<Role> findAll();
    Role findById(Integer id);
    void create(Role role);
    void update(Integer id, Role role);
    void deleteById(Integer id);
    void checkIfExistsById(Integer id);

}
