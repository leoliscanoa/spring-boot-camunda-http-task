package com.lliscano.springrestapi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {
    private String fullName;
    private String birthdate;
    private String gender;
    private Long age;
}
