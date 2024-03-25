package com.bfz.usermanagementapi.role.infraestructure.adapter.common.mapper;

import com.bfz.usermanagementapi.role.core.domain.model.Page;
import com.bfz.usermanagementapi.role.core.domain.model.Role;
import com.bfz.usermanagementapi.role.infraestructure.adapter.in.rest.dto.PageResponseDto;
import com.bfz.usermanagementapi.role.infraestructure.adapter.in.rest.dto.RoleRequestDto;
import com.bfz.usermanagementapi.role.infraestructure.adapter.in.rest.dto.RoleResponseDto;
import com.bfz.usermanagementapi.role.infraestructure.adapter.out.persistence.jpa.RoleEntity;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;

import java.util.List;

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
    PageResponseDto<List<RoleResponseDto>> getPageResponseDto(Page<List<Role>> rolePage);

}
