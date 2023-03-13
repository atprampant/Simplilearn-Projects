package org.simplilearn.sportyshoes.repositories;

import org.simplilearn.sportyshoes.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, String> {

    public Admin findByUsername(String username);
}
