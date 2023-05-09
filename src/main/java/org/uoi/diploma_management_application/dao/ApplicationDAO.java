package org.uoi.diploma_management_application.dao;

import org.uoi.diploma_management_application.entity.Application;
import org.uoi.diploma_management_application.entity.ApplicationKey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ApplicationDAO extends JpaRepository<Application, Integer> {
    void deleteById(ApplicationKey id);

}
