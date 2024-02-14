package com.bfz.usermanagementapi.role.infraestructure.mapper;

import com.bfz.usermanagementapi.role.domain.model.Role;
import com.bfz.usermanagementapi.role.infraestructure.dto.RoleRequestDto;
import com.bfz.usermanagementapi.role.infraestructure.dto.RoleResponseDto;
import com.bfz.usermanagementapi.role.infraestructure.persistence.jpa.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

/**
 * @author bruferper
 */

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IRoleMapper {

    RoleEntity getRoleEntity(Role role);

    Role getRoleFromEntity(RoleEntity entity);

    RoleResponseDto getRoleResponseDto(Role role);
    Role getRoleFromDto(RoleRequestDto dto);

}
