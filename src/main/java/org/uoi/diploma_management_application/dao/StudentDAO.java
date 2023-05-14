package org.uoi.diploma_management_application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.uoi.diploma_management_application.entity.Student;

@Repository
public interface StudentDAO extends JpaRepository<Student, Integer> {

    public Student findById(int studentId);


}