package org.uoi.diploma_management_application.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import org.uoi.diploma_management_application.entity.Professor;

@Repository
public interface ProfessorDAO extends JpaRepository<Professor, Integer> {

    public Professor findById(int p_Id);

    public Professor findByFirstName(String firstName);


}
