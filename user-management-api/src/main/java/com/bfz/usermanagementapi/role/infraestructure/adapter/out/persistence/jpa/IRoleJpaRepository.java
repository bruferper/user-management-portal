package com.bfz.usermanagementapi.role.infraestructure.adapter.out.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bruferper
 */

@Repository
public interface IRoleJpaRepository extends JpaRepository<RoleEntity, Integer> { }
