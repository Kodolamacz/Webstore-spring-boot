package com.bs.boot.webstore.domain;

import lombok.*;

import javax.jws.soap.SOAPBinding;
import javax.persistence.*;
import java.util.Set;

/**
 * Created by Blazej on 24.10.2018.
 */
@Entity
@Table(name = "roles")
@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<User> users;
}
