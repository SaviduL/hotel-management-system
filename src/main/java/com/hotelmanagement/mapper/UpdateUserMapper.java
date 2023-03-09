package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.UpdateUserDTO;
import com.hotelmanagement.entity.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UpdateUserMapper {
    User updateUserDTOToUser(UpdateUserDTO updateUserDTO);

    UpdateUserDTO userToUpdateUserDTO(User user);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromUpdateUserDTO(UpdateUserDTO updateUserDTO, @MappingTarget User user);
}
