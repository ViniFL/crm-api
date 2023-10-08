package com.vinicius.salescontrol.services;

import com.vinicius.salescontrol.dto.ContactDTO;
import com.vinicius.salescontrol.entities.Contact;
import com.vinicius.salescontrol.repositories.ContactRepository;
import com.vinicius.salescontrol.services.exceptions.DatabaseException;
import com.vinicius.salescontrol.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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

    @Transactional
    public ContactDTO update(Long id, ContactDTO dto) {
        try{
            Contact entity = repository.getReferenceById(id);
            copyDtoToEntity(dto, entity);
            entity = repository.save(entity);
            return new ContactDTO();
        }
        catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
    }

    @Transactional(propagation = Propagation.SUPPORTS)
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Recurso não encontrado");
        }
        try {
            repository.deleteById(id);
        }
        catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Falha de integridade referencial");
        }
    }

    private void copyDtoToEntity(ContactDTO dto, Contact entity) {
        entity.setName(dto.getName());
        entity.setEmail(dto.getEmail());
        entity.setCellphone(dto.getCellphone());
    }
}
