package com.bs.boot.webstore.domain;

import lombok.*;

import javax.persistence.Embeddable;

/**
 * Created by Blazej on 24.10.2018.
 */
@Embeddable
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Address {

    private String countryCode;
    private String state;
    private String city;
    private String zipCode;
    private String street;
    private String houseNo;
}
