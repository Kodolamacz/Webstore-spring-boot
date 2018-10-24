package com.bs.boot.webstore.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Set;

/**
 * Created by Blazej on 24.10.2018.
 */
@Entity
@Table(name = "carts")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "cart", fetch = FetchType.LAZY)
    private Set<CartItem> items;

    private BigDecimal totalPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
