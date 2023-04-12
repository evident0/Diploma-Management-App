package myy803.springboot.sb_tutorial_3_thymeleaf.dao;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.User;

public interface UserDAO extends JpaRepository<User, Integer> {

    Optional<User> findByUsername(String username);

}
