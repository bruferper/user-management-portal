package com.bfz.usermanagementapi.user.application.service;

import com.bfz.usermanagementapi.role.application.port.input.IRoleService;
import com.bfz.usermanagementapi.role.domain.model.Role;
import com.bfz.usermanagementapi.user.application.port.input.IUserService;
import com.bfz.usermanagementapi.user.application.port.output.IUserRepository;
import com.bfz.usermanagementapi.user.domain.exception.UserNotFoundException;
import com.bfz.usermanagementapi.user.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

/**
 * @author bruferper
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IRoleService roleService;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public void create(User user) {
        checkIfRolesExists(user.getRoles());
        userRepository.create(user);
    }

    @Override
    public void update(Long id, User user) {
        User userToUpdate = findById(id);
        checkIfRolesExists(user.getRoles());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
        userToUpdate.setPhoto(user.getPhoto());
        userToUpdate.setRoles(user.getRoles());
        userRepository.update(userToUpdate);
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

    private void checkIfRolesExists(Set<Role> roles) {
        for (Role role: roles) {
            roleService.checkIfExistsById(role.getId());
        }
    }

}
