package org.simplilearn.sportyshoes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shoes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long shoeId;

    private String name;

    private BigDecimal amount;

    private int size;

    @JsonIgnore
    private int quantityAvailable;


}
