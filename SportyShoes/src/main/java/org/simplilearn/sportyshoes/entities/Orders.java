package org.simplilearn.sportyshoes.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.annotation.PostConstruct;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Orders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long orderId;


    private BigDecimal totalAmount;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @JsonIgnore
    private LocalDate localDate;


    @ManyToOne
    @JoinColumn(name="id")
    private Users user;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderItems> items=new ArrayList<>();


    public void addOrderItems(OrderItems orderItems)
    {
        orderItems.setOrder(this);
        items.add(orderItems);
    }

    public void removeOrderItems(OrderItems orderItems)
    {
        items.remove(orderItems);
        orderItems.setOrder(null);
    }

    public void getTotalAmount()
    {
        BigDecimal total=BigDecimal.ZERO;
        for(OrderItems item:items)
        {
            totalAmount=total.add(item.getShoes().getAmount().multiply(new BigDecimal(item.getQuantity())));
        }
    }
}
