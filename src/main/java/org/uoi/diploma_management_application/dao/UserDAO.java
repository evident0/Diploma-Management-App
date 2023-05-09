package org.uoi.diploma_management_application.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.uoi.diploma_management_application.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
