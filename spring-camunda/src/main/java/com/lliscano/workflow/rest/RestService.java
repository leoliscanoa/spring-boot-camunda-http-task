package com.lliscano.workflow.rest;

import com.lliscano.workflow.dto.ResponseDTO;
import com.lliscano.workflow.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@NoArgsConstructor
@Slf4j
public class RestService {

    public ResponseEntity<ResponseDTO> getUserById(String url) {
        RestTemplate restTemplate = new RestTemplate();
        log.debug("URI: {}",url);
        ResponseEntity<ResponseDTO> response = restTemplate.getForEntity(url,ResponseDTO.class);
        log.debug("RESPONSE: {}", response.getBody());
        return response;
    }

}
