package org.simplilearn.sportyshoes.repositories;

import org.simplilearn.sportyshoes.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<Users, Long> {

    public Users findByUsername(String username);

    public Users findByEmail(String email);
}
