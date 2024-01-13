package com.vinicius.salescontrol.repositories;

import com.vinicius.salescontrol.entities.Sale;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface SaleRepository extends JpaRepository<Sale, Long> {
    Optional<Sale> findSaleByDate(LocalDateTime date);
}
