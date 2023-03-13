package org.simplilearn.sportyshoes.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.simplilearn.sportyshoes.enums.StatusCodes;

@NoArgsConstructor
@Getter
public class BaseException extends RuntimeException{

    private StatusCodes statusCodes;

    public BaseException(StatusCodes statusCodes){
        super(statusCodes.getMessage());
        this.statusCodes = statusCodes;
    }


}
