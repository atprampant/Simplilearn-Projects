package org.simplilearn.sportyshoes.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import org.apache.coyote.Response;
import org.simplilearn.sportyshoes.enums.StatusCodes;
import org.slf4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ResponseGenerator {

    ObjectMapper objectMapper=new ObjectMapper();

    @SneakyThrows
    public ResponseEntity<String> generateResponse(StatusCodes statusCodes)
    {
        ResponseInfo<String> responseInfo=new ResponseInfo<>();
        responseInfo.setErrorCode(statusCodes.getMessageCode());
        responseInfo.setMessage(statusCodes.getMessage());
        responseInfo.setTraceId(MDC.get("tradeId"));
        return new ResponseEntity<>((objectMapper.writeValueAsString(responseInfo)),statusCodes.getStatus());
    }
    @SneakyThrows
    public <T> ResponseEntity<String> generateResponse(T data,HttpStatus status){
        ResponseInfo<T> responseInfo=new ResponseInfo<>();
        responseInfo.setData(data);
        responseInfo.setTraceId(MDC.get("tradeId"));
        return new ResponseEntity<>(objectMapper.writeValueAsString(responseInfo),status);
    }
}
