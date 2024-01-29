package com.vinicius.salescontrol.services;

import com.vinicius.salescontrol.dto.SaleDTO;
import com.vinicius.salescontrol.entities.Sale;
import com.vinicius.salescontrol.repositories.SaleRepository;
import com.vinicius.salescontrol.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;


@Service
public class SaleService {

    @Autowired
    private SaleRepository repository;

    @Transactional(readOnly = true)
    public List<Sale> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public SaleDTO findById(Long id) {
        Sale sale = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Venda não encontrada"));
        return new SaleDTO(sale);
    }

    @Transactional(readOnly = true)
    public SaleDTO findSaleByDate(LocalDateTime date) {
        Sale sale = repository.findSaleByDate(date).orElseThrow(() -> new ResourceNotFoundException("Venda não encontrada"));
        return new SaleDTO(sale);
    }

    
}
