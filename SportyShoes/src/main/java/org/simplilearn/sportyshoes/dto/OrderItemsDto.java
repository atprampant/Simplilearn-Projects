package org.simplilearn.sportyshoes.dto;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OrderItemsDto {

    private String username;
    private int orderId;
    private int shoeId;
    private int quantity;

}
