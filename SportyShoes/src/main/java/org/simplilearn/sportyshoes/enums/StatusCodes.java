package org.simplilearn.sportyshoes.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum StatusCodes {

    USERNAME_ALREADY_EXISTS("Username already exists","ERR_CREATING_USER", HttpStatus.BAD_REQUEST),
    USERNAME_NOT_FOUND("Username not found","ERR_SEARCHING_USER",HttpStatus.NOT_FOUND),
    EMAIL_ALREADY_USED("Email has already been used on another account","ERR_CREATING_USER",HttpStatus.BAD_REQUEST),
    EMAIL_NOT_FOUND("No user with email found","ERR_SEARCHING_USER",HttpStatus.NOT_FOUND),
    ORDER_NOT_FOUND("No orders made on the specified date","ERR_SEARCHING_ORDER",HttpStatus.NOT_FOUND);


    private final String message;
    private final String messageCode;
    private final HttpStatus status;

}
