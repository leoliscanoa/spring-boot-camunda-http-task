package com.lliscano.springrestapi.mapper;

import com.lliscano.springrestapi.dto.UserDTO;
import com.lliscano.springrestapi.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    @Mapping(source = "birthdate", target = "birthdate", dateFormat = "dd/MM/yyyy")
    UserDTO toDto(Users user);
}
