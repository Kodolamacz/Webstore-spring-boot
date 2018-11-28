package com.bs.boot.webstore.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

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
    @EqualsAndHashCode.Exclude
    @JsonIgnore
    private Category category;
    private BigDecimal unitPrice;
    private int unitsInStock;
    private String description;

    @Transient
    @ToString.Exclude
    private MultipartFile[] images;

    @ToString.Exclude
    private String imagePaths;

    @OneToOne(fetch = FetchType.LAZY)
    @ToString.Exclude
    @JsonIgnore
    private CartItem cartItem;

    //photo or list of photos
}
