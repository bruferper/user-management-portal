package com.bfz.usermanagementapi.user.core.application.port.in.usecase;

import com.bfz.usermanagementapi.role.core.application.port.in.usecase.IRoleService;
import com.bfz.usermanagementapi.role.core.domain.model.Role;
import com.bfz.usermanagementapi.user.core.application.port.out.IUserEmailService;
import com.bfz.usermanagementapi.user.core.application.port.out.IUserRepository;
import com.bfz.usermanagementapi.user.core.application.port.out.IUserStorage;
import com.bfz.usermanagementapi.user.core.domain.exception.UserNotFoundException;
import com.bfz.usermanagementapi.user.core.domain.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Set;
import java.util.UUID;

/**
 * @author bruferper
 */

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {

    private final IUserRepository userRepository;
    private final IRoleService roleService;
    private final IUserStorage userStorage;
    private final IUserEmailService userEmailService;

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public void create(User user, MultipartFile file) {
        checkIfRolesExists(user.getRoles());
        // Upload image storage service
        user.setPhotoName(generatePhotoName(file.getOriginalFilename()));
        user.setPhotoUrl(userStorage.uploadPhoto(user.getPhotoName(), file));
        userRepository.create(user);
        // Send email notification
        userEmailService.sendBasicEmail(user.getEmail(), "Welcome", "You has been successfully registered!");
    }

    @Override
    public void update(Long id, User user) {
        User userToUpdate = findById(id);
        checkIfRolesExists(user.getRoles());
        userToUpdate.setFirstName(user.getFirstName());
        userToUpdate.setLastName(user.getLastName());
        userToUpdate.setEmail(user.getEmail());
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

    private String generatePhotoName(String photoName) {
        String photoExtension = StringUtils.getFilenameExtension(photoName);
        return String.format("%s.%s", UUID.randomUUID(), photoExtension);
    }

}
