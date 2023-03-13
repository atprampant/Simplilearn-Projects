package org.simplilearn.sportyshoes.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.simplilearn.sportyshoes.enums.StatusCodes;

@NoArgsConstructor
@Getter
public class EmailNotFoundException extends BaseException{
    public EmailNotFoundException(StatusCodes statusCodes){super(statusCodes);}
}
