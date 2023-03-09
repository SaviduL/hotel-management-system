package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.ChangePasswordUserDTO;
import com.hotelmanagement.entity.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ChangePasswordUserMapper {
    User changePasswordUserDTOToUser(ChangePasswordUserDTO changePasswordUserDTO);

    ChangePasswordUserDTO userToChangePasswordUserDTO(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromChangePasswordUserDTO(ChangePasswordUserDTO changePasswordUserDTO, @MappingTarget User user);
}
