package com.lliscano.springrestapi.mapper;

import com.lliscano.springrestapi.dto.UserDTO;
import com.lliscano.springrestapi.entity.Users;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;

@Mapper(componentModel = "spring")
public interface UsersMapper {
    @Mapping(source = "birthdate", target = "birthdate", dateFormat = "dd/MM/yyyy")
    UserDTO toDto(Users user);

    @AfterMapping
    default void calculateUserAge(Users source, @MappingTarget UserDTO target) {
        target.setFullName(source.getFirstname().toUpperCase()+" "+source.getLastname().toUpperCase());
        target.setAge((long) Period.between(source.getBirthdate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate(), LocalDate.now()).getYears());
    }
}
