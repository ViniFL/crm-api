package com.vinicius.salescontrol.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Entity
@Table(name = "tb_users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;
    @Column(unique = true)
    private String email;
    private String password;

    @OneToMany(mappedBy = "seller")
    private List<Client> clients;

    @OneToMany(mappedBy = "seller")
    private List<Sale> sales;
}
