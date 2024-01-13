package com.vinicius.salescontrol.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;

import java.util.List;

@Entity
@Table(name = "tb_clients")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String name;

    @Email
    @Column(unique = true)
    private String email;

    @Column(unique = true)
    private String cellphone;

    @OneToMany(mappedBy = "client")
    private List<Sale> madeSales;

    @OneToMany(mappedBy = "seller")
    private List<User> sellerClients;

}
