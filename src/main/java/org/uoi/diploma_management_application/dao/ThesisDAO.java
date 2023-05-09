package org.uoi.diploma_management_application.dao;

import org.uoi.diploma_management_application.entity.Thesis;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ThesisDAO extends JpaRepository<Thesis, Integer> {

    public Thesis findById(int theId);

}
