package com.bfz.usermanagementapi.role.application.service;

import com.bfz.usermanagementapi.role.application.port.input.IRoleService;
import com.bfz.usermanagementapi.role.application.port.output.IRoleRepository;
import com.bfz.usermanagementapi.role.domain.exception.RoleNotFoundException;
import com.bfz.usermanagementapi.role.domain.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author bruferper
 */

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {

    private final IRoleRepository roleRepository;

    @Override
    public List<Role> findAll() {
        return roleRepository.findAll();
    }

    @Override
    public Role findById(Integer id) {
        return roleRepository.findById(id).orElseThrow(() -> new RoleNotFoundException("Role not found"));
    }

    @Override
    public void create(Role role) {
        roleRepository.create(role);
    }

    @Override
    public void update(Integer id, Role role) {
        Role roleToUpdate = findById(id);
        roleToUpdate.setName(role.getName());
        roleRepository.update(roleToUpdate);
    }

    @Override
    public void deleteById(Integer id) {
        checkIfExistsById(id);
        roleRepository.deleteById(id);
    }

    @Override
    public void checkIfExistsById(Integer id) {
        if(!roleRepository.existsById(id)) throw new RoleNotFoundException("Role not found");
    }

}
