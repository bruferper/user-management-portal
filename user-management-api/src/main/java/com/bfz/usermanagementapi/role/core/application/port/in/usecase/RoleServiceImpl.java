package com.bfz.usermanagementapi.role.core.application.port.in.usecase;

import com.bfz.usermanagementapi.role.core.application.port.out.IRoleRepository;
import com.bfz.usermanagementapi.role.core.domain.exception.RoleNotFoundException;
import com.bfz.usermanagementapi.role.core.domain.model.Page;
import com.bfz.usermanagementapi.role.core.domain.model.Role;
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
    public Page<List<Role>> findAll(int pageNo, int pageSize) {
        return roleRepository.findAll(pageNo, pageSize);
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
