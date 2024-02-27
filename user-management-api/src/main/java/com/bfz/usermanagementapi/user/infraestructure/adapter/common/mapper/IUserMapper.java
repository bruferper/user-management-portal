package com.bfz.usermanagementapi.user.infraestructure.adapter.common.mapper;

import com.bfz.usermanagementapi.role.core.domain.model.Role;
import com.bfz.usermanagementapi.user.core.domain.model.User;
import com.bfz.usermanagementapi.user.infraestructure.adapter.in.rest.dto.UserRequestDto;
import com.bfz.usermanagementapi.user.infraestructure.adapter.in.rest.dto.UserResponseDto;
import com.bfz.usermanagementapi.user.infraestructure.adapter.out.persistence.jpa.UserEntity;
import org.mapstruct.*;

/**
 * @author bruferper
 */

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface IUserMapper {

    UserEntity getUserEntity(User user);

    User getUserFromEntity(UserEntity entity);

    UserResponseDto getUserResponseDto(User user);

    @Mapping(source = "roleIds", target = "roles", qualifiedByName = "idToRole")
    User getUserFromDto(UserRequestDto dto);

    @Named("idToRole")
    static Role idToRole(Integer id) {
        return Role.builder().id(id).build();
    }

}
