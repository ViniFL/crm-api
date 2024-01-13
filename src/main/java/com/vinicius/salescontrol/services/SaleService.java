package com.vinicius.salescontrol.services;

import com.vinicius.salescontrol.repositories.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SaleService {

    @Autowired
    private SaleRepository saleRepository;

}
