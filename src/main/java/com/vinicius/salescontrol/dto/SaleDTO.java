package com.vinicius.salescontrol.dto;

import com.vinicius.salescontrol.entities.Sale;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class SaleDTO {

    private Long id;

    @Size(max = 14)
    @NotBlank(message = "Insira o valor total da venda")
    private BigDecimal totalValue;

    @Size(max = 14)
    @NotBlank(message = "Insira o valor averbado para a empresa na venda")
    private BigDecimal averbatedValue;

    @NotBlank(message = "Insira a data que a venda foi concluída")
    private LocalDateTime date;

    public SaleDTO() {
    }

    public SaleDTO(Long id, BigDecimal totalValue, BigDecimal averbatedValue, LocalDateTime date) {
        this.id = id;
        this.totalValue = totalValue;
        this.averbatedValue = averbatedValue;
        this.date = date;
    }

    public SaleDTO(Sale entity) {
        id = entity.getId();
        totalValue = entity.getTotalValue();
        averbatedValue = entity.getAverbatedValue();
    }

    public Long getId() {
        return id;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public BigDecimal getAverbatedValue() {
        return averbatedValue;
    }

    public LocalDateTime getDate() {
        return date;
    }
}
