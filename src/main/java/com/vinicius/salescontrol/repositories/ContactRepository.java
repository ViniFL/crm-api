package com.vinicius.salescontrol.repositories;

import com.vinicius.salescontrol.entities.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {
}
