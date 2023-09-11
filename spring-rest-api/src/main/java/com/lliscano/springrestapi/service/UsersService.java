package com.lliscano.springrestapi.service;

import com.lliscano.springrestapi.dto.ResponseDTO;
import com.lliscano.springrestapi.dto.UserDTO;
import com.lliscano.springrestapi.exception.RecordNotFoundException;
import com.lliscano.springrestapi.mapper.UsersMapper;
import com.lliscano.springrestapi.repository.UsersRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@AllArgsConstructor
@Slf4j
public class UsersService {
    private final UsersRepository repository;
    private final UsersMapper mapper;

    public ResponseDTO<UserDTO> getUserById(Long id) {
        return ResponseDTO.<UserDTO>builder()
                .timestamp(Instant.now())
                .message("User found successfully")
                .data(this.mapper.toDto(
                        this.repository
                                .findById(id)
                                .orElseThrow(() -> new RecordNotFoundException("User not found by given id " + id))))
                .build();
    }
}
