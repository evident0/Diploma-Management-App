package myy803.springboot.sb_tutorial_3_thymeleaf.dao;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Application;
import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationDAO extends JpaRepository<Application, Integer> {
}
