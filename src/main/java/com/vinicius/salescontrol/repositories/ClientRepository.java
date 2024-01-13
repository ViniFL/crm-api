package com.vinicius.salescontrol.repositories;

import com.vinicius.salescontrol.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Optional<Client> findClientByName(String name);
    Optional<Client> findClientByEmail(String email);
}
