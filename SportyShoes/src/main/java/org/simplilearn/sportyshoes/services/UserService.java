package org.simplilearn.sportyshoes.services;

import org.modelmapper.ModelMapper;
import org.simplilearn.sportyshoes.dto.CreateUserDto;
import org.simplilearn.sportyshoes.entities.Users;
import org.simplilearn.sportyshoes.enums.StatusCodes;
import org.simplilearn.sportyshoes.exceptions.EmailAlreadyExistsException;
import org.simplilearn.sportyshoes.exceptions.EmailNotFoundException;
import org.simplilearn.sportyshoes.exceptions.UsernameAlreadyExistsException;
import org.simplilearn.sportyshoes.exceptions.UsernameNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.simplilearn.sportyshoes.repositories.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    ModelMapper modelMapper=new ModelMapper();

    public Users createUser(CreateUserDto createUserDto){

        Users user=modelMapper.map(createUserDto, Users.class);
        Optional<Users> byEmail= Optional.ofNullable(userRepository.findByEmail(user.getEmail()));
        Optional<Users> byUsername= Optional.ofNullable(userRepository.findByUsername(user.getUsername()));
        if(byEmail.isPresent()){
            throw new EmailAlreadyExistsException(StatusCodes.EMAIL_ALREADY_USED);
        }
        else if(byUsername.isPresent()){
            throw new UsernameAlreadyExistsException(StatusCodes.USERNAME_ALREADY_EXISTS);
        }
        return userRepository.save(user);
    }

    public List<Users> getAllUsers()
    {
        return userRepository.findAll();
    }

    public Users getUserByUsername(String username)
    {
        Optional<Users> user = Optional.ofNullable(userRepository.findByUsername(username));
        if(user.isEmpty()){
                throw new UsernameNotFoundException(StatusCodes.USERNAME_NOT_FOUND);
        }
        return user.get();
    }

    public Users getUserByEmail(String email)
    {
        Optional<Users> user= Optional.ofNullable(userRepository.findByEmail(email));
        if(user.isEmpty()){
            throw new EmailNotFoundException(StatusCodes.EMAIL_NOT_FOUND);
        }
        return user.get();
    }
}
