package com.bs.boot.webstore.domain;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Blazej on 24.10.2018.
 */
@Entity
@Table(name = "users")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String email;
    private String phoneNo;

    @Transient
    private String matchingPassword;

    @Embedded
    private Address address;

    @OneToMany(mappedBy = "user",
        cascade = CascadeType.ALL,
        fetch = FetchType.LAZY
    )
    private Set<Cart> carts;


    @ManyToMany(mappedBy = "users",
            cascade = CascadeType.ALL
    )
    private Set<Role> roles;
}
