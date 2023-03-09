package com.hotelmanagement.mapper;

import com.hotelmanagement.dto.StoreUserDTO;
import com.hotelmanagement.entity.User;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface StoreUserMapper {
    @Mapping(source = "employeeId", target = "employeeID.id")
    User storeUserDTOToUser(StoreUserDTO storeUserDTO);

    @Mapping(source = "employeeID.id", target = "employeeId")
    StoreUserDTO userToStoreUserDTO(User user);

    @Mapping(source = "employeeId", target = "employeeID.id")
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    User updateUserFromStoreUserDTO(StoreUserDTO storeUserDTO, @MappingTarget User user);
}
