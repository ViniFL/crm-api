package com.vinicius.salescontrol.repositories;

import com.vinicius.salescontrol.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
