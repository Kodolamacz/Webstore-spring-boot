package com.bs.boot.webstore.domain;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by Blazej on 24.10.2018.
 */
@Entity
@Table(name = "products")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.ALL)
    private Category category;
    private BigDecimal unitPrice;
    private int unitsInStock;
    private String description;


    @OneToOne(fetch = FetchType.LAZY)
    private CartItem cartItem;

    //photo or list of photos
}
