package myy803.springboot.sb_tutorial_3_thymeleaf.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

    public Student findById(int p_Id);


}