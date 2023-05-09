package myy803.springboot.sb_tutorial_3_thymeleaf.service;

import java.util.List;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.*;


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