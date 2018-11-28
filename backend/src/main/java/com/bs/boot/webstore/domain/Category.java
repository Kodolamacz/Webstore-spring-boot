package com.bs.boot.webstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.EqualsAndHashCode.Exclude;

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
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    @ToString.Exclude
    private Set<Product> products;

    public void addProduct(Product product){
        if (this.products != null) {
            this.products.add(product);
        }
        else {
            this.products = new HashSet<>();
            this.products.add(product);
        }
    }
}
