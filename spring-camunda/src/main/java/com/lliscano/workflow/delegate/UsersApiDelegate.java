package com.lliscano.workflow.delegate;

import com.lliscano.workflow.dto.ResponseDTO;
import com.lliscano.workflow.dto.UserDTO;
import com.lliscano.workflow.rest.RestService;
import lombok.extern.slf4j.Slf4j;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


@Component("UsersApiDelegate")
@Slf4j
public class UsersApiDelegate implements JavaDelegate {

    @Value("${service.users.url}")
    private String usersUrl;
    @Override
    public void execute(DelegateExecution delegateExecution) throws Exception {
        final String id = (String) delegateExecution.getVariable("id");
        final RestService restService = new RestService();
        ResponseEntity<ResponseDTO> response = restService.getUserById(usersUrl+"/"+id);
        log.debug("RESPONSE: {}",response);
    }
}
