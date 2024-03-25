package com.bfz.usermanagementapi.role.infraestructure.adapter.out.persistence.jpa;

import com.bfz.usermanagementapi.role.core.application.port.out.IRoleRepository;
import com.bfz.usermanagementapi.role.core.domain.model.Page;
import com.bfz.usermanagementapi.role.core.domain.model.Role;
import com.bfz.usermanagementapi.role.infraestructure.adapter.common.mapper.IRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * @author bruferper
 */

@Component
@RequiredArgsConstructor
public class RoleRepositoryImpl implements IRoleRepository {

    private final IRoleJpaRepository roleJpaRepository;
    private final IRoleMapper roleMapper;

    @Override
    public Page<List<Role>> findAll(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        org.springframework.data.domain.Page<RoleEntity> pageEntity = roleJpaRepository.findAll(pageable);
        List<Role> roleList = pageEntity.getContent().stream().map(roleMapper::getRoleFromEntity).toList();
        return Page.<List<Role>>builder()
                .pageNo(pageEntity.getNumber())
                .pageSize(pageEntity.getSize())
                .totalPages(pageEntity.getTotalPages())
                .totalElements(pageEntity.getTotalElements())
                .content(roleList)
                .build();
    }

    @Override
    public Optional<Role> findById(Integer id) {
        return roleJpaRepository.findById(id).map(roleMapper::getRoleFromEntity);
    }

    @Override
    public void create(Role role) {
        roleJpaRepository.save(roleMapper.getRoleEntity(role));
    }

    @Override
    public void update(Role role) {
        roleJpaRepository.save(roleMapper.getRoleEntity(role));
    }

    @Override
    public void deleteById(Integer id) {
        roleJpaRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Integer id) {
        return roleJpaRepository.existsById(id);
    }

}
