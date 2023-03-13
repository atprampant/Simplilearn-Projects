package org.simplilearn.sportyshoes.controllers;

import org.modelmapper.ModelMapper;
import org.simplilearn.sportyshoes.dto.CreateUserDto;
import org.simplilearn.sportyshoes.entities.Users;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.simplilearn.sportyshoes.services.UserService;

@RestController
@RequestMapping("/sportyshoes/user")
public class UserController {

    @Autowired
    UserService userService;

    ModelMapper modelMapper=new ModelMapper();

    @PostMapping("")
    public ResponseEntity<Users> createUser(@RequestBody CreateUserDto createUserDto) {
        return new ResponseEntity<Users>(userService.createUser(createUserDto), HttpStatus.CREATED);
    }


}
