package myy803.springboot.sb_tutorial_3_thymeleaf.dao;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer> {

    public Subject findById(int subjectId);

    public List<Subject> findAll();

}