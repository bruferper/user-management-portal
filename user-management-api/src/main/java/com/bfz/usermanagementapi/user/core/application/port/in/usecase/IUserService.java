package com.bfz.usermanagementapi.user.core.application.port.in.usecase;

import com.bfz.usermanagementapi.user.core.domain.model.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
 * @author bruferper
 */

public interface IUserService {

    List<User> findAll();
    User findById(Long id);
    void create(User user, MultipartFile photo) throws IOException;
    void update(Long id, User user);
    void deleteById(Long id);

}
