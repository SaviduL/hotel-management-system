package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ResourceUserDTO;
import com.hotelmanagement.entity.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ResourceUserMapper {
    @Mapping(source = "employee", target = "employeeID")
    User resourceUserDTOToUser(ResourceUserDTO resourceUserDTO);

    @Mapping(source = "employeeID", target = "employee")
    ResourceUserDTO userToResourceUserDTO(User user);

    @Mapping(source = "employee", target = "employeeID")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromResourceUserDTO(ResourceUserDTO resourceUserDTO, @MappingTarget User user);
}
