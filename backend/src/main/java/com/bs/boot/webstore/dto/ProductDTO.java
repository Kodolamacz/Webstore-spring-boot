package com.bs.boot.webstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * Created by Blazej on 29.11.2018.
 */
@AllArgsConstructor
@Setter
@Getter
public class ProductDTO {

    private Long id;
    private String name;
    private String categoryName;
    private BigDecimal unitPrice;
    private int unitsInStock;
    private String description;
    private String imagePaths;
}
