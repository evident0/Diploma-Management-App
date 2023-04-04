package myy803.springboot.sb_tutorial_3_thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Professor;

@Repository
public interface ProfessorDAO extends JpaRepository<Professor, Integer> {

    public Professor findById(int p_Id);


}
