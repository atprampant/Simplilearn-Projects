package org.simplilearn.sportyshoes.exceptions;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.simplilearn.sportyshoes.enums.StatusCodes;

@Getter
@NoArgsConstructor
public class UsernameNotFoundException extends BaseException{
        public UsernameNotFoundException(StatusCodes statusCodes){super(statusCodes);}
}
