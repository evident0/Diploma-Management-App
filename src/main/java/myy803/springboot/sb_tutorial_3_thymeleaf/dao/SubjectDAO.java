package myy803.springboot.sb_tutorial_3_thymeleaf.dao;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer> {

    public Subject findById(int subjectId);

}