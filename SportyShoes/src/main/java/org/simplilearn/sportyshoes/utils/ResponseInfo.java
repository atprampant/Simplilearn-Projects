package org.simplilearn.sportyshoes.utils;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.simplilearn.sportyshoes.enums.StatusCodes;
import org.slf4j.MDC;

import javax.websocket.server.ServerEndpoint;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResponseInfo<T> {

    T data;
    String message;
    String errorCode;
    String traceId;


    public ResponseInfo(StatusCodes statusCodes){
        this.errorCode=statusCodes.getMessageCode();
        this.message=statusCodes.getMessage();
        this.traceId= MDC.get("tradeId");
    }
}
