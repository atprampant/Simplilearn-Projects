package org.simplilearn.sportyshoes.repositories;

import org.simplilearn.sportyshoes.entities.OrderItems;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItems, Integer> {
}
