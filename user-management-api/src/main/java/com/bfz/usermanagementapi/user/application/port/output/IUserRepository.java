package com.bfz.usermanagementapi.user.application.port.output;

import com.bfz.usermanagementapi.user.domain.model.User;

import java.util.List;
import java.util.Optional;

/**
 * @author bruferper
 */

public interface IUserRepository {

    List<User> findAll();
    Optional<User> findById(Long id);
    void create(User user);
    void update(User user);
    void deleteById(Long id);

}
