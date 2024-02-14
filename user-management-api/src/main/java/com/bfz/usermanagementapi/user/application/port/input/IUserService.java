package com.bfz.usermanagementapi.user.application.port.input;

import com.bfz.usermanagementapi.user.domain.model.User;

import java.util.List;

/**
 * @author bruferper
 */

public interface IUserService {

    List<User> findAll();
    User findById(Long id);
    void create(User user);
    void update(Long id, User user);
    void deleteById(Long id);

}
