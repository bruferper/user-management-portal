package com.bfz.usermanagementapi.user.infraestructure.adapter.out.persistence.jpa;

import com.bfz.usermanagementapi.user.core.domain.model.User;
import com.bfz.usermanagementapi.user.core.application.port.out.IUserRepository;
import com.bfz.usermanagementapi.user.infraestructure.adapter.common.mapper.IUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * @author bruferper
 */

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements IUserRepository {

    private final IUserJpaRepository userRepository;
    private final IUserMapper userMapper;

    @Override
    public List<User> findAll() {
        return userRepository.findAll().stream().map(userMapper::getUserFromEntity).toList();
    }

    @Override
    public Optional<User> findById(Long id) {
        return userRepository.findById(id).map(userMapper::getUserFromEntity);
    }

    @Override
    public void create(User user) {
        UserEntity userEntity = userMapper.getUserEntity(user);
        userRepository.save(userEntity);
    }

    @Override
    public void update(User user) {
        userRepository.save(userMapper.getUserEntity(user));
    }

    @Override
    public void deleteById(Long id) {
        userRepository.deleteById(id);
    }

}
