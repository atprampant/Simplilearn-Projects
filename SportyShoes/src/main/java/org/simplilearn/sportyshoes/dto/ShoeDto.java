package org.simplilearn.sportyshoes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShoeDto {

    private String name;
    private double amount;
    private int size;
    private int quantityAvailable;

}
