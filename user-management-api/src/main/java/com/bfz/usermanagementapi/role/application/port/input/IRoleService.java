package com.bfz.usermanagementapi.role.application.port.input;

import com.bfz.usermanagementapi.role.domain.model.Role;

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
