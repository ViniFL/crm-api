package com.vinicius.salescontrol.repositories;

import com.vinicius.salescontrol.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
