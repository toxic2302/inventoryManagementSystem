package de.toxic2302.inventorymanagementsystem.core.modules.user.mapper;

import de.toxic2302.inventorymanagementsystem.core.modules.user.dto.UserDto;
import de.toxic2302.inventorymanagementsystem.core.modules.user.entity.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = MappingConstants.ComponentModel.SPRING)
public interface UserMapper {
    User toEntity(UserDto userDTO);

    UserDto toDto(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User partialUpdate(UserDto userDTO, @MappingTarget User user);
}