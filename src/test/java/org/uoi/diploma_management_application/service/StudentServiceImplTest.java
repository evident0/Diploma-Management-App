package org.uoi.diploma_management_application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.uoi.diploma_management_application.dao.ApplicationDAO;
import org.uoi.diploma_management_application.dao.StudentDAO;
import org.uoi.diploma_management_application.dao.SubjectDAO;
import org.uoi.diploma_management_application.entity.Application;
import org.uoi.diploma_management_application.entity.Professor;
import org.uoi.diploma_management_application.entity.Role;
import org.uoi.diploma_management_application.entity.Student;
import org.uoi.diploma_management_application.entity.Subject;
import org.uoi.diploma_management_application.entity.Thesis;
import org.uoi.diploma_management_application.entity.User;

@ContextConfiguration(classes = {StudentServiceImpl.class})
@ExtendWith(SpringExtension.class)
class StudentServiceImplTest {
    @MockBean
    private ApplicationDAO applicationDAO;

    @MockBean
    private StudentDAO studentDAO;

    @Autowired
    private StudentServiceImpl studentServiceImpl;

    @MockBean
    private SubjectDAO subjectDAO;

    /**
     * Method under test: {@link StudentServiceImpl#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Student> studentList = new ArrayList<>();

        //make a student
        Student student = new Student("Bob",
                "Mastoras",
                "Bob@builder.com",
                5,
                5);

        Student student2 = new Student("Bobby",
                "Mastorakos",
                "Bobby@builder.com",
                10,
                10);

        studentList.add(student);
        studentList.add(student2);

        when(studentDAO.findAll()).thenReturn(studentList);
        List<Student> actualFindAllResult = studentServiceImpl.findAll();
        assertSame(studentList, actualFindAllResult);
        verify(studentDAO).findAll();
    }

    /**
     * Method under test: {@link StudentServiceImpl#findAll()}
     */
    @Test
    void testFindAllException() {
        when(studentDAO.findAll()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> studentServiceImpl.findAll());
        verify(studentDAO).findAll();
    }

    /**
     * Method under test: {@link StudentServiceImpl#findById(int)}
     */
    @Test
    void testFindById() {

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(new User());
        when(studentDAO.findById(1)).thenReturn(student4);
        assertSame(student4, studentServiceImpl.findById(1));
        verify(studentDAO).findById(anyInt());
    }

    @Test
    void testFindByIdRunTimeException() {

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(new User());
        when(studentDAO.findById(1)).thenReturn(student4);
        assertThrows(RuntimeException.class, () -> studentServiceImpl.findById(42));
        verify(studentDAO).findById(anyInt());
    }


    /**
     * Method under test: {@link StudentServiceImpl#findSubjectById(int)}
     */
    @Test
    void testFindSubjectById() {

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");

        Subject subject = new Subject();
        subject.setDescription("The characteristics of someone or something");
        subject.setProfessor(professor);
        subject.setSubjectId(1);
        subject.setThesis(thesis);
        subject.setTitle("Dr");
        when(subjectDAO.findById(1)).thenReturn(subject);
        assertSame(subject, studentServiceImpl.findSubjectById(1));
        verify(subjectDAO).findById(1);
    }


    /**
     * Method under test: {@link StudentServiceImpl#save(Student)}
     */
    @Test
    void testSave() {
        ArrayList<Application> applications = new ArrayList<>();

        Student theStudent = new Student();
        theStudent.setApplications(new ArrayList<>());
        theStudent.setAverageGrade(10.0f);
        theStudent.setEmail("jane.doe@example.org");
        theStudent.setFirstName("Jane");
        theStudent.setLastName("Doe");
        theStudent.setRemainingCourses(1);
        theStudent.setStudentId(1);
        theStudent.setUser(new User());
        studentServiceImpl.save(theStudent);
        verify(studentDAO).save(theStudent);
    }

    /**
     * Method under test: {@link StudentServiceImpl#saveApplication(Application)}
     */
    @Test
    void testSaveApplication() {
        Application application = new Application(1,1,
                new Student(1,"bob","doe","email",1,1),
                new Subject());
        studentServiceImpl.saveApplication(application);
        verify(applicationDAO).save(application);
    }

    /**
     * Method under test: {@link StudentServiceImpl#saveApplication(Application)}
     */
    @Test
    void testSaveApplicationException() {
        when(applicationDAO.save(Mockito.<Application>any())).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> studentServiceImpl.saveApplication(new Application()));
        verify(applicationDAO).save(Mockito.<Application>any());
    }

    /**
     * Method under test: {@link StudentServiceImpl#getAvailableSubjects()}
     */
    @Test
    void testGetAvailableSubjects() {
        Subject subject = new Subject();
        subject.setDescription("Description");
        subject.setProfessor(new Professor(1,"BOB","DOE","email"));

        ArrayList<Subject> subjectList = new ArrayList<>();
        subjectList.add(subject);

        when(subjectDAO.findAll()).thenReturn(subjectList);
        List<Subject> actualAvailableSubjects = studentServiceImpl.getAvailableSubjects();
        assertSame(subjectList, actualAvailableSubjects);
        verify(subjectDAO).findAll();
    }


}

