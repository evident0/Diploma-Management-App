package org.uoi.diploma_management_application.dao;

import org.uoi.diploma_management_application.entity.Subject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SubjectDAO extends JpaRepository<Subject, Integer> {

    public Subject findById(int subjectId);

    public List<Subject> findAll();

}