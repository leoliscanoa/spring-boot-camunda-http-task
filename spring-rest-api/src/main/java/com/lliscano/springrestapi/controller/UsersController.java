package com.lliscano.springrestapi.controller;

import com.lliscano.springrestapi.dto.ResponseDTO;
import com.lliscano.springrestapi.dto.UserDTO;
import com.lliscano.springrestapi.service.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/users")
public class UsersController {

    private final UsersService service;
    @GetMapping(value = "/{id}")
    public ResponseEntity<ResponseDTO<UserDTO>> getUserById(
            @PathVariable(name = "id") Long id
    ) {
        return new ResponseEntity<>(this.service.getUserById(id), HttpStatus.OK);
    }
}
