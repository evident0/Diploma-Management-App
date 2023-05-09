package org.uoi.diploma_management_application.service;

import org.uoi.diploma_management_application.entity.Student;

import java.util.List;

public interface SelectionStrategy {

    public Student selectApplicant(List<Student> applicants);
}
