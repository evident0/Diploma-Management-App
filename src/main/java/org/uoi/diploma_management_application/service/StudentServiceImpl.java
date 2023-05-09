package org.uoi.diploma_management_application.service;

import java.util.List;

import org.uoi.diploma_management_application.dao.ApplicationDAO;
import org.uoi.diploma_management_application.dao.StudentDAO;
import org.uoi.diploma_management_application.dao.SubjectDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.uoi.diploma_management_application.entity.Application;
import org.uoi.diploma_management_application.entity.Student;
import org.uoi.diploma_management_application.entity.Subject;
import org.uoi.diploma_management_application.entity.Thesis;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentDAO studentRepository;

    @Autowired
    private SubjectDAO subjectRepository;

    @Autowired
    private ApplicationDAO applicationRepository;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    public StudentServiceImpl(StudentDAO theStudentRepository, SubjectDAO theSubjectRepository, ApplicationDAO theApplicationRepository, SubjectDAO subjectDAO) {
        studentRepository = theStudentRepository;
        subjectRepository = theSubjectRepository;
        applicationRepository = theApplicationRepository;
        this.subjectDAO = subjectDAO;
    }

    public StudentServiceImpl() {
    }

    @Override
    @Transactional
    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    @Override
    @Transactional
    public Student findById(int studentId) {
        Student result = studentRepository.findById(studentId);

        if (result != null ) {
            return result;
        }
        else {
            throw new RuntimeException("Did not find Student id - " + studentId);
        }
    }

    @Override
    @Transactional
    public Subject findSubjectById(int subjectId) {
        Subject result = subjectRepository.findById(subjectId);

        if (result != null ) {
            return result;
        }
        else {
            throw new RuntimeException("Did not find Subject id - " + subjectId);
        }
    }

    @Override
    public List<Application> listStudentSubjects(int studentId) {
        //find by id
        Student student = studentRepository.findById(studentId);
        return student.getApplications();
    }

    @Override
    @Transactional
    public void save(Student theStudent) {
        studentRepository.save(theStudent);
    }

    @Override
    @Transactional
    public void saveApplication(Application theApplication) {
        applicationRepository.save(theApplication);
    }

    @Override
    @Transactional
    public void deleteById(int studentId) {
        studentRepository.deleteById(studentId);
    }

    public List<Subject> getAvailableSubjects() {
        List<Subject> subjects = subjectDAO.findAll();
        return subjects;
    }

    @Override
    public Thesis getThesis(Student student){
        return student.getThesis();
    }

}
