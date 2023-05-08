package myy803.springboot.sb_tutorial_3_thymeleaf.service;

import java.util.List;

import myy803.springboot.sb_tutorial_3_thymeleaf.dao.ApplicationDAO;
import myy803.springboot.sb_tutorial_3_thymeleaf.dao.ProfessorDAO;
import myy803.springboot.sb_tutorial_3_thymeleaf.dao.StudentDAO;
import myy803.springboot.sb_tutorial_3_thymeleaf.dao.SubjectDAO;
import myy803.springboot.sb_tutorial_3_thymeleaf.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
        // TODO Auto-generated constructor stub
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
            // we didn't find the Student
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
            // we didn't find the Subject
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

}
