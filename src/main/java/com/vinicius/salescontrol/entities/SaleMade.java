package com.vinicius.salescontrol.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Table(name = "tb_sale_made")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class SaleMade {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private BigDecimal totalValue;
    private BigDecimal averbatedValue;

    @ManyToOne
    @JoinColumn(name = "")
    private User seller;

    @ManyToOne
    @JoinColumn(name = "")
    private Client client;
}
