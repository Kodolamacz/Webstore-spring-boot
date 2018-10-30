package com.bs.boot.webstore.domain;

import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Blazej on 27.10.2018.
 */
@Entity
@Table(name = "category")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "category")
    private Set<Product> products;

    void addProduct(Product product){
        if (this.products != null) {
            this.products.add(product);
        }
        else {
            this.products = new HashSet<>();
            this.products.add(product);
        }
    }
}
