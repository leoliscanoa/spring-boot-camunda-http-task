package com.lliscano.workflow.rest;

import com.fasterxml.jackson.core.type.TypeReference;
import com.lliscano.workflow.dto.ResponseDTO;
import com.lliscano.workflow.dto.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class RestService {

    public ResponseEntity<ResponseDTO> getUserById(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(url,ResponseDTO.class);
    }

}
