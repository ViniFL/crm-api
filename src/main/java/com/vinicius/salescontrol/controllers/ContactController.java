package com.vinicius.salescontrol.controllers;

import com.vinicius.salescontrol.dto.ContactDTO;
import com.vinicius.salescontrol.services.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/contacts")
public class ContactController {

    @Autowired
    ContactService service;

    @GetMapping
    public ResponseEntity<Page<ContactDTO>> findAll(Pageable pageable) {
        Page<ContactDTO> dto = service.findAll(pageable);
        return ResponseEntity.ok(dto);
    }
}
