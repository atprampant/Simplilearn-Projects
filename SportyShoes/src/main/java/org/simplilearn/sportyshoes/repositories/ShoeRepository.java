package org.simplilearn.sportyshoes.repositories;

import org.simplilearn.sportyshoes.entities.Shoes;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShoeRepository extends JpaRepository<Shoes, Long> {

}
