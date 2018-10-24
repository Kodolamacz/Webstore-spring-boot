package com.bs.boot.webstore.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Blazej on 24.10.2018.
 */
@Entity
@Table(name = "cart_items")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class CartItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private Product product;

    private int quantity;
    private BigDecimal totalItemPrice;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id")
    private Cart cart;
}
