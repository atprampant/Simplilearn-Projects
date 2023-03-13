package org.simplilearn.sportyshoes.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.simplilearn.sportyshoes.enums.StatusCodes;

@Getter
@NoArgsConstructor
public class OrderNotFoundException extends BaseException{
        public OrderNotFoundException(StatusCodes statusCodes){super(statusCodes);}
}
