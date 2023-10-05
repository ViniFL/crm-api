package com.vinicius.salescontrol.services;

import com.vinicius.salescontrol.dto.ContactDTO;
import com.vinicius.salescontrol.entities.Contact;
import com.vinicius.salescontrol.repositories.ContactRepository;
import com.vinicius.salescontrol.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ContactService {

    @Autowired
    private ContactRepository repository;

    @Transactional(readOnly = true)
    public ContactDTO findById(Long id) {
        Contact contact = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado"));
        return new ContactDTO(contact);
    }

    @Transactional(readOnly = true)
    public Page<ContactDTO> findAll(Pageable pageable) {
        Page<Contact> result = repository.findAll(pageable);
        return result.map(x -> new ContactDTO(x));
    }

    @Transactional
    public ContactDTO insert(ContactDTO dto) {
        Contact entity = new Contact();
        copyDtoToEntity(dto, entity);
        entity = repository.save(entity);
        return new ContactDTO();
    }



    private void copyDtoToEntity(ContactDTO dto, Contact entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setCellphone(dto.getCellphone());
    }
}
