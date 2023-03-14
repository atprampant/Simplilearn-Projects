package org.simplilearn.sportyshoes.services;


import org.modelmapper.ModelMapper;
import org.simplilearn.sportyshoes.dto.AdminLoginDto;
import org.simplilearn.sportyshoes.entities.Admin;
import org.simplilearn.sportyshoes.enums.StatusCodes;
import org.simplilearn.sportyshoes.exceptions.UsernameNotFoundException;
import org.simplilearn.sportyshoes.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class AdminService {


    @Autowired
    AdminRepository adminRepository;

    ModelMapper modelMapper=new ModelMapper();


    public Admin createAdmin(Admin admin){
        return adminRepository.save(admin);
    }

    public boolean validateAdminLogin(AdminLoginDto adminLoginDto){
        boolean login=false;

        Optional<Admin> admin= Optional.ofNullable(adminRepository.findByUsername(adminLoginDto.getUsername()));
        if(admin.isEmpty()){
            throw new UsernameNotFoundException(StatusCodes.USERNAME_NOT_FOUND);
        }
        Admin loginAdmin=adminRepository.findByUsername(adminLoginDto.getUsername());
        if(loginAdmin.getPassword().equals(adminLoginDto.getPassword()))
        {login=true;}
        return login;
    }

}
