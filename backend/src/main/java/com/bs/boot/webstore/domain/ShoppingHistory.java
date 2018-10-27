package com.bs.boot.webstore.domain;

import lombok.*;

import javax.persistence.*;

/**
 * Created by Blazej on 27.10.2018.
 */
@Entity
@Table(name = "shopping_history")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ShoppingHistory {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String shopping_details;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private User owner;
}
