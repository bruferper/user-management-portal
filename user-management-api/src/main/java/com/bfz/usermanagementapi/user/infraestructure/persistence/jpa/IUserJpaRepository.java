package com.bfz.usermanagementapi.user.infraestructure.persistence.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author bruferper
 */

@Repository
public interface IUserJpaRepository extends JpaRepository<UserEntity, Long> { }
