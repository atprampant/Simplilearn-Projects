package org.simplilearn.sportyshoes.services;

import org.simplilearn.sportyshoes.entities.Admin;
import org.simplilearn.sportyshoes.repositories.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {

    @Autowired
    AdminRepository adminRepository;

    public Admin createAdmin(Admin admin){
        return adminRepository.save(admin);
    }

}
