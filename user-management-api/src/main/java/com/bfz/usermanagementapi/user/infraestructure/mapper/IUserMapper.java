package com.bfz.usermanagementapi.user.infraestructure.mapper;

import com.bfz.usermanagementapi.role.domain.model.Role;
import com.bfz.usermanagementapi.user.domain.model.User;
import com.bfz.usermanagementapi.user.infraestructure.dto.UserRequestDto;
import com.bfz.usermanagementapi.user.infraestructure.dto.UserResponseDto;
import com.bfz.usermanagementapi.user.infraestructure.persistence.jpa.UserEntity;
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
