package org.uoi.diploma_management_application.service;

import java.util.List;
import org.uoi.diploma_management_application.entity.Application;
import org.uoi.diploma_management_application.entity.Student;
import org.uoi.diploma_management_application.entity.Subject;
import org.uoi.diploma_management_application.entity.Thesis;


public interface StudentService {

    public List<Student> findAll();

    public Student findById(int studentId);

    public Subject findSubjectById(int subjectId);

    public void save(Student theStudent);

    public void saveApplication(Application theApplication);

    public void deleteById(int studentId);

    public List<Application> listStudentSubjects(int studentId);

    public List<Subject> getAvailableSubjects();

    public Thesis getThesis(Student student);
}