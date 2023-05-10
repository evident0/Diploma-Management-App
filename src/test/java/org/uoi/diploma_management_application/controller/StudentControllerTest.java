package org.uoi.diploma_management_application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
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
import org.uoi.diploma_management_application.service.StudentService;
import org.uoi.diploma_management_application.service.StudentServiceImpl;

@ContextConfiguration(classes = {StudentController.class})
@ExtendWith(SpringExtension.class)
class StudentControllerTest {
    @Autowired
    private StudentController studentController;

    @MockBean
    private StudentService studentService;

    /**
     * Method under test: {@link StudentController#getUserHome(Authentication, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserHome() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserHome(StudentController.java:28)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.service.StudentServiceImpl.findById(StudentServiceImpl.java:51)
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserHome(StudentController.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(new Professor());
        user.setRole(Role.STUDENT);
        user.setStudent(new Student());
        user.setUsername("janedoe");

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(user);

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(new Professor());
        user2.setRole(Role.STUDENT);
        user2.setStudent(new Student());
        user2.setUsername("janedoe");

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student);
        user3.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user3);

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(new Professor());
        user4.setRole(Role.STUDENT);
        user4.setStudent(new Student());
        user4.setUsername("janedoe");

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(user4);

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(new Professor());
        user5.setRole(Role.STUDENT);
        user5.setStudent(new Student());
        user5.setUsername("janedoe");

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(user5);

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor3);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student2);
        user6.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user6);

        User user7 = new User();
        user7.setId(1);
        user7.setPassword("iloveyou");
        user7.setProfessor(professor2);
        user7.setRole(Role.STUDENT);
        user7.setStudent(student3);
        user7.setUsername("janedoe");
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user7, "Credentials");

        studentController.getUserHome(authentication, new ConcurrentModel());
    }

    /**
     * Method under test: {@link StudentController#getUserHome(Authentication, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserHome2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserHome(StudentController.java:28)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserHome(StudentController.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(null, "Credentials");

        studentController.getUserHome(authentication, new ConcurrentModel());
    }

    /**
     * Method under test: {@link StudentController#getUserHome(Authentication, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserHome3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserHome(StudentController.java:28)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.service.StudentServiceImpl.findById(StudentServiceImpl.java:51)
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserHome(StudentController.java:29)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(professor);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(new User());

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(professor3);
        user2.setRole(Role.STUDENT);
        user2.setStudent(student2);
        user2.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor2);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);
        User user4 = mock(User.class);
        when(user4.getStudent()).thenReturn(student4);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user4, "Credentials");

        studentController.getUserHome(authentication, new ConcurrentModel());
    }

    /**
     * Method under test: {@link StudentController#getUserHome(Authentication, Model)}
     */
    @Test
    void testGetUserHome4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserHome(StudentController.java:28)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(professor);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(new User());

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(professor3);
        user2.setRole(Role.STUDENT);
        user2.setStudent(student2);
        user2.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor2);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);
        StudentDAO theStudentRepository = mock(StudentDAO.class);
        when(theStudentRepository.findById(anyInt())).thenReturn(student4);
        SubjectDAO subjectDAO = mock(SubjectDAO.class);
        when(subjectDAO.findAll()).thenReturn(new ArrayList<>());
        StudentController studentController = new StudentController(
                new StudentServiceImpl(theStudentRepository, mock(SubjectDAO.class), mock(ApplicationDAO.class), subjectDAO));

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(new User());

        Student student5 = new Student();
        student5.setApplications(new ArrayList<>());
        student5.setAverageGrade(10.0f);
        student5.setEmail("jane.doe@example.org");
        student5.setFirstName("Jane");
        student5.setLastName("Doe");
        student5.setRemainingCourses(1);
        student5.setStudentId(1);
        student5.setUser(new User());

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(professor4);
        user4.setRole(Role.STUDENT);
        user4.setStudent(student5);
        user4.setUsername("janedoe");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(user4);

        Professor professor6 = new Professor();
        professor6.setEmail("jane.doe@example.org");
        professor6.setFirstName("Jane");
        professor6.setLastName("Doe");
        professor6.setPId(1);
        professor6.setUser(new User());

        Student student6 = new Student();
        student6.setApplications(new ArrayList<>());
        student6.setAverageGrade(10.0f);
        student6.setEmail("jane.doe@example.org");
        student6.setFirstName("Jane");
        student6.setLastName("Doe");
        student6.setRemainingCourses(1);
        student6.setStudentId(1);
        student6.setUser(new User());

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(professor6);
        user5.setRole(Role.STUDENT);
        user5.setStudent(student6);
        user5.setUsername("janedoe");

        Student student7 = new Student();
        student7.setApplications(new ArrayList<>());
        student7.setAverageGrade(10.0f);
        student7.setEmail("jane.doe@example.org");
        student7.setFirstName("Jane");
        student7.setLastName("Doe");
        student7.setRemainingCourses(1);
        student7.setStudentId(1);
        student7.setUser(user5);

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor5);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student7);
        user6.setUsername("janedoe");

        Student student8 = new Student();
        student8.setApplications(new ArrayList<>());
        student8.setAverageGrade(10.0f);
        student8.setEmail("jane.doe@example.org");
        student8.setFirstName("Jane");
        student8.setLastName("Doe");
        student8.setRemainingCourses(1);
        student8.setStudentId(1);
        student8.setUser(user6);
        User user7 = mock(User.class);
        doNothing().when(user7).setStudent(Mockito.<Student>any());
        when(user7.getStudent()).thenReturn(student8);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user7, "Credentials");

        assertEquals("student/dashboard", studentController.getUserHome(authentication, new ConcurrentModel()));
        verify(theStudentRepository).findById(anyInt());
        verify(subjectDAO).findAll();
        verify(user7, atLeast(1)).getStudent();
        verify(user7).setStudent(Mockito.<Student>any());
    }

    /**
     * Method under test: {@link StudentController#getUserAvailableSubjects(Authentication, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserAvailableSubjects() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserAvailableSubjects(StudentController.java:57)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.service.StudentServiceImpl.getAvailableSubjects(StudentServiceImpl.java:100)
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserAvailableSubjects(StudentController.java:59)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(new Professor());
        user.setRole(Role.STUDENT);
        user.setStudent(new Student());
        user.setUsername("janedoe");

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(user);

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(new Professor());
        user2.setRole(Role.STUDENT);
        user2.setStudent(new Student());
        user2.setUsername("janedoe");

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student);
        user3.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user3);

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(new Professor());
        user4.setRole(Role.STUDENT);
        user4.setStudent(new Student());
        user4.setUsername("janedoe");

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(user4);

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(new Professor());
        user5.setRole(Role.STUDENT);
        user5.setStudent(new Student());
        user5.setUsername("janedoe");

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(user5);

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor3);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student2);
        user6.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user6);

        User user7 = new User();
        user7.setId(1);
        user7.setPassword("iloveyou");
        user7.setProfessor(professor2);
        user7.setRole(Role.STUDENT);
        user7.setStudent(student3);
        user7.setUsername("janedoe");
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user7, "Credentials");

        studentController.getUserAvailableSubjects(authentication, new ConcurrentModel());
    }

    /**
     * Method under test: {@link StudentController#getUserAvailableSubjects(Authentication, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserAvailableSubjects2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserAvailableSubjects(StudentController.java:57)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserAvailableSubjects(StudentController.java:58)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(null, "Credentials");

        studentController.getUserAvailableSubjects(authentication, new ConcurrentModel());
    }

    /**
     * Method under test: {@link StudentController#getUserAvailableSubjects(Authentication, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetUserAvailableSubjects3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserAvailableSubjects(StudentController.java:57)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.service.StudentServiceImpl.getAvailableSubjects(StudentServiceImpl.java:100)
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserAvailableSubjects(StudentController.java:59)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(professor);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(new User());

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(professor3);
        user2.setRole(Role.STUDENT);
        user2.setStudent(student2);
        user2.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor2);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);
        User user4 = mock(User.class);
        when(user4.getStudent()).thenReturn(student4);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user4, "Credentials");

        studentController.getUserAvailableSubjects(authentication, new ConcurrentModel());
    }

    /**
     * Method under test: {@link StudentController#getUserAvailableSubjects(Authentication, Model)}
     */
    @Test
    void testGetUserAvailableSubjects4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserAvailableSubjects(StudentController.java:57)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        SubjectDAO subjectDAO = mock(SubjectDAO.class);
        when(subjectDAO.findAll()).thenReturn(new ArrayList<>());
        StudentController studentController = new StudentController(new StudentServiceImpl(mock(StudentDAO.class),
                mock(SubjectDAO.class), mock(ApplicationDAO.class), subjectDAO));

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(professor);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(new User());

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(professor3);
        user2.setRole(Role.STUDENT);
        user2.setStudent(student2);
        user2.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor2);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);
        User user4 = mock(User.class);
        when(user4.getStudent()).thenReturn(student4);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user4, "Credentials");

        assertEquals("student/available-subjects",
                studentController.getUserAvailableSubjects(authentication, new ConcurrentModel()));
        verify(subjectDAO).findAll();
        verify(user4).getStudent();
    }

    /**
     * Method under test: {@link StudentController#getUserAvailableSubjects(Authentication, Model)}
     */
    @Test
    void testGetUserAvailableSubjects5() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.getUserAvailableSubjects(StudentController.java:57)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        SubjectDAO subjectDAO = mock(SubjectDAO.class);
        when(subjectDAO.findAll()).thenReturn(new ArrayList<>());
        StudentController studentController = new StudentController(new StudentServiceImpl(mock(StudentDAO.class),
                mock(SubjectDAO.class), mock(ApplicationDAO.class), subjectDAO));

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(professor);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(new User());

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(professor3);
        user2.setRole(Role.STUDENT);
        user2.setStudent(student2);
        user2.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor2);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");
        Student student4 = mock(Student.class);
        when(student4.getStudentId()).thenReturn(1);
        doNothing().when(student4).setApplications(Mockito.<List<Application>>any());
        doNothing().when(student4).setAverageGrade(anyFloat());
        doNothing().when(student4).setEmail(Mockito.<String>any());
        doNothing().when(student4).setFirstName(Mockito.<String>any());
        doNothing().when(student4).setLastName(Mockito.<String>any());
        doNothing().when(student4).setRemainingCourses(anyInt());
        doNothing().when(student4).setStudentId(anyInt());
        doNothing().when(student4).setUser(Mockito.<User>any());
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);
        User user4 = mock(User.class);
        when(user4.getStudent()).thenReturn(student4);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user4, "Credentials");

        assertEquals("student/available-subjects",
                studentController.getUserAvailableSubjects(authentication, new ConcurrentModel()));
        verify(subjectDAO).findAll();
        verify(user4).getStudent();
        verify(student4).getStudentId();
        verify(student4).setApplications(Mockito.<List<Application>>any());
        verify(student4).setAverageGrade(anyFloat());
        verify(student4).setEmail(Mockito.<String>any());
        verify(student4).setFirstName(Mockito.<String>any());
        verify(student4).setLastName(Mockito.<String>any());
        verify(student4).setRemainingCourses(anyInt());
        verify(student4).setStudentId(anyInt());
        verify(student4).setUser(Mockito.<User>any());
    }

    /**
     * Method under test: {@link StudentController#applySubject(int, int)}
     */
    @Test
    void testApplySubject() throws Exception {
        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(professor);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(new User());

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(professor3);
        user2.setRole(Role.STUDENT);
        user2.setStudent(student2);
        user2.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor2);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(new Professor());
        user4.setRole(Role.STUDENT);
        user4.setStudent(new Student());
        user4.setUsername("janedoe");

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(user4);

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(new Professor());
        user5.setRole(Role.STUDENT);
        user5.setStudent(new Student());
        user5.setUsername("janedoe");

        Student student5 = new Student();
        student5.setApplications(new ArrayList<>());
        student5.setAverageGrade(10.0f);
        student5.setEmail("jane.doe@example.org");
        student5.setFirstName("Jane");
        student5.setLastName("Doe");
        student5.setRemainingCourses(1);
        student5.setStudentId(1);
        student5.setUser(user5);

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor4);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student5);
        user6.setUsername("janedoe");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(user6);

        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");

        Subject subject = new Subject();
        subject.setDescription("The characteristics of someone or something");
        subject.setProfessor(professor5);
        subject.setSubjectId(1);
        subject.setThesis(thesis);
        subject.setTitle("Dr");
        when(studentService.findById(anyInt())).thenReturn(student4);
        when(studentService.findSubjectById(anyInt())).thenReturn(subject);
        doNothing().when(studentService).saveApplication(Mockito.<Application>any());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/student/apply-subject");
        MockHttpServletRequestBuilder paramResult = getResult.param("subjectId", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("thisStudentId", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/student/dashboard"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/student/dashboard"));
    }

    /**
     * Method under test: {@link StudentController#changeDetails(Authentication, Model)}
     */
    @Test
    void testChangeDetails() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.changeDetails(StudentController.java:67)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(new Professor());
        user.setRole(Role.STUDENT);
        user.setStudent(new Student());
        user.setUsername("janedoe");

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(user);

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(new Professor());
        user2.setRole(Role.STUDENT);
        user2.setStudent(new Student());
        user2.setUsername("janedoe");

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student);
        user3.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user3);

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(new Professor());
        user4.setRole(Role.STUDENT);
        user4.setStudent(new Student());
        user4.setUsername("janedoe");

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(user4);

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(new Professor());
        user5.setRole(Role.STUDENT);
        user5.setStudent(new Student());
        user5.setUsername("janedoe");

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(user5);

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor3);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student2);
        user6.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user6);

        User user7 = new User();
        user7.setId(1);
        user7.setPassword("iloveyou");
        user7.setProfessor(professor2);
        user7.setRole(Role.STUDENT);
        user7.setStudent(student3);
        user7.setUsername("janedoe");
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user7, "Credentials");

        assertEquals("student/student-details", studentController.changeDetails(authentication, new ConcurrentModel()));
    }

    /**
     * Method under test: {@link StudentController#changeDetails(Authentication, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testChangeDetails2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.changeDetails(StudentController.java:67)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.changeDetails(StudentController.java:68)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(null, "Credentials");

        studentController.changeDetails(authentication, new ConcurrentModel());
    }

    /**
     * Method under test: {@link StudentController#changeDetails(Authentication, Model)}
     */
    @Test
    void testChangeDetails3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.changeDetails(StudentController.java:67)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(professor);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(new User());

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(professor3);
        user2.setRole(Role.STUDENT);
        user2.setStudent(student2);
        user2.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor2);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);
        User user4 = mock(User.class);
        when(user4.getStudent()).thenReturn(student4);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user4, "Credentials");

        assertEquals("student/student-details", studentController.changeDetails(authentication, new ConcurrentModel()));
        verify(user4).getStudent();
    }

    /**
     * Method under test: {@link StudentController#saveDetails(Authentication, Student)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveDetails() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.saveDetails(StudentController.java:76)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.service.StudentServiceImpl.save(StudentServiceImpl.java:84)
        //       at org.uoi.diploma_management_application.controller.StudentController.saveDetails(StudentController.java:81)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(new Professor());
        user.setRole(Role.STUDENT);
        user.setStudent(new Student());
        user.setUsername("janedoe");

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(user);

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(new Professor());
        user2.setRole(Role.STUDENT);
        user2.setStudent(new Student());
        user2.setUsername("janedoe");

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student);
        user3.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user3);

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(new Professor());
        user4.setRole(Role.STUDENT);
        user4.setStudent(new Student());
        user4.setUsername("janedoe");

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(user4);

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(new Professor());
        user5.setRole(Role.STUDENT);
        user5.setStudent(new Student());
        user5.setUsername("janedoe");

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(user5);

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor3);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student2);
        user6.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user6);

        User user7 = new User();
        user7.setId(1);
        user7.setPassword("iloveyou");
        user7.setProfessor(professor2);
        user7.setRole(Role.STUDENT);
        user7.setStudent(student3);
        user7.setUsername("janedoe");
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user7, "Credentials");

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(new User());

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(new User());

        User user8 = new User();
        user8.setId(1);
        user8.setPassword("iloveyou");
        user8.setProfessor(professor4);
        user8.setRole(Role.STUDENT);
        user8.setStudent(student4);
        user8.setUsername("janedoe");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(user8);

        Professor professor6 = new Professor();
        professor6.setEmail("jane.doe@example.org");
        professor6.setFirstName("Jane");
        professor6.setLastName("Doe");
        professor6.setPId(1);
        professor6.setUser(new User());

        Student student5 = new Student();
        student5.setApplications(new ArrayList<>());
        student5.setAverageGrade(10.0f);
        student5.setEmail("jane.doe@example.org");
        student5.setFirstName("Jane");
        student5.setLastName("Doe");
        student5.setRemainingCourses(1);
        student5.setStudentId(1);
        student5.setUser(new User());

        User user9 = new User();
        user9.setId(1);
        user9.setPassword("iloveyou");
        user9.setProfessor(professor6);
        user9.setRole(Role.STUDENT);
        user9.setStudent(student5);
        user9.setUsername("janedoe");

        Student student6 = new Student();
        student6.setApplications(new ArrayList<>());
        student6.setAverageGrade(10.0f);
        student6.setEmail("jane.doe@example.org");
        student6.setFirstName("Jane");
        student6.setLastName("Doe");
        student6.setRemainingCourses(1);
        student6.setStudentId(1);
        student6.setUser(user9);

        User user10 = new User();
        user10.setId(1);
        user10.setPassword("iloveyou");
        user10.setProfessor(professor5);
        user10.setRole(Role.STUDENT);
        user10.setStudent(student6);
        user10.setUsername("janedoe");

        Student theStudent = new Student();
        theStudent.setApplications(new ArrayList<>());
        theStudent.setAverageGrade(10.0f);
        theStudent.setEmail("jane.doe@example.org");
        theStudent.setFirstName("Jane");
        theStudent.setLastName("Doe");
        theStudent.setRemainingCourses(1);
        theStudent.setStudentId(1);
        theStudent.setUser(user10);
        studentController.saveDetails(authentication, theStudent);
    }

    /**
     * Method under test: {@link StudentController#saveDetails(Authentication, Student)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveDetails2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.saveDetails(StudentController.java:76)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.saveDetails(StudentController.java:77)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(null, "Credentials");

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(professor);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(new User());

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(professor3);
        user2.setRole(Role.STUDENT);
        user2.setStudent(student2);
        user2.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor2);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");

        Student theStudent = new Student();
        theStudent.setApplications(new ArrayList<>());
        theStudent.setAverageGrade(10.0f);
        theStudent.setEmail("jane.doe@example.org");
        theStudent.setFirstName("Jane");
        theStudent.setLastName("Doe");
        theStudent.setRemainingCourses(1);
        theStudent.setStudentId(1);
        theStudent.setUser(user3);
        studentController.saveDetails(authentication, theStudent);
    }

    /**
     * Method under test: {@link StudentController#saveDetails(Authentication, Student)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveDetails3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.saveDetails(StudentController.java:76)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.service.StudentServiceImpl.save(StudentServiceImpl.java:84)
        //       at org.uoi.diploma_management_application.controller.StudentController.saveDetails(StudentController.java:81)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(professor);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(new User());

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(professor3);
        user2.setRole(Role.STUDENT);
        user2.setStudent(student2);
        user2.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor2);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);
        User user4 = mock(User.class);
        when(user4.getStudent()).thenReturn(student4);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user4, "Credentials");

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(new User());

        Student student5 = new Student();
        student5.setApplications(new ArrayList<>());
        student5.setAverageGrade(10.0f);
        student5.setEmail("jane.doe@example.org");
        student5.setFirstName("Jane");
        student5.setLastName("Doe");
        student5.setRemainingCourses(1);
        student5.setStudentId(1);
        student5.setUser(new User());

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(professor4);
        user5.setRole(Role.STUDENT);
        user5.setStudent(student5);
        user5.setUsername("janedoe");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(user5);

        Professor professor6 = new Professor();
        professor6.setEmail("jane.doe@example.org");
        professor6.setFirstName("Jane");
        professor6.setLastName("Doe");
        professor6.setPId(1);
        professor6.setUser(new User());

        Student student6 = new Student();
        student6.setApplications(new ArrayList<>());
        student6.setAverageGrade(10.0f);
        student6.setEmail("jane.doe@example.org");
        student6.setFirstName("Jane");
        student6.setLastName("Doe");
        student6.setRemainingCourses(1);
        student6.setStudentId(1);
        student6.setUser(new User());

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor6);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student6);
        user6.setUsername("janedoe");

        Student student7 = new Student();
        student7.setApplications(new ArrayList<>());
        student7.setAverageGrade(10.0f);
        student7.setEmail("jane.doe@example.org");
        student7.setFirstName("Jane");
        student7.setLastName("Doe");
        student7.setRemainingCourses(1);
        student7.setStudentId(1);
        student7.setUser(user6);

        User user7 = new User();
        user7.setId(1);
        user7.setPassword("iloveyou");
        user7.setProfessor(professor5);
        user7.setRole(Role.STUDENT);
        user7.setStudent(student7);
        user7.setUsername("janedoe");

        Student theStudent = new Student();
        theStudent.setApplications(new ArrayList<>());
        theStudent.setAverageGrade(10.0f);
        theStudent.setEmail("jane.doe@example.org");
        theStudent.setFirstName("Jane");
        theStudent.setLastName("Doe");
        theStudent.setRemainingCourses(1);
        theStudent.setStudentId(1);
        theStudent.setUser(user7);
        studentController.saveDetails(authentication, theStudent);
    }

    /**
     * Method under test: {@link StudentController#saveDetails(Authentication, Student)}
     */
    @Test
    void testSaveDetails4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.saveDetails(StudentController.java:76)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(professor);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(new User());

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(professor3);
        user2.setRole(Role.STUDENT);
        user2.setStudent(student2);
        user2.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor2);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);
        StudentDAO theStudentRepository = mock(StudentDAO.class);
        when(theStudentRepository.save(Mockito.<Student>any())).thenReturn(student4);
        StudentController studentController = new StudentController(new StudentServiceImpl(theStudentRepository,
                mock(SubjectDAO.class), mock(ApplicationDAO.class), mock(SubjectDAO.class)));

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(new User());

        Student student5 = new Student();
        student5.setApplications(new ArrayList<>());
        student5.setAverageGrade(10.0f);
        student5.setEmail("jane.doe@example.org");
        student5.setFirstName("Jane");
        student5.setLastName("Doe");
        student5.setRemainingCourses(1);
        student5.setStudentId(1);
        student5.setUser(new User());

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(professor4);
        user4.setRole(Role.STUDENT);
        user4.setStudent(student5);
        user4.setUsername("janedoe");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(user4);

        Professor professor6 = new Professor();
        professor6.setEmail("jane.doe@example.org");
        professor6.setFirstName("Jane");
        professor6.setLastName("Doe");
        professor6.setPId(1);
        professor6.setUser(new User());

        Student student6 = new Student();
        student6.setApplications(new ArrayList<>());
        student6.setAverageGrade(10.0f);
        student6.setEmail("jane.doe@example.org");
        student6.setFirstName("Jane");
        student6.setLastName("Doe");
        student6.setRemainingCourses(1);
        student6.setStudentId(1);
        student6.setUser(new User());

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(professor6);
        user5.setRole(Role.STUDENT);
        user5.setStudent(student6);
        user5.setUsername("janedoe");

        Student student7 = new Student();
        student7.setApplications(new ArrayList<>());
        student7.setAverageGrade(10.0f);
        student7.setEmail("jane.doe@example.org");
        student7.setFirstName("Jane");
        student7.setLastName("Doe");
        student7.setRemainingCourses(1);
        student7.setStudentId(1);
        student7.setUser(user5);

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor5);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student7);
        user6.setUsername("janedoe");

        Student student8 = new Student();
        student8.setApplications(new ArrayList<>());
        student8.setAverageGrade(10.0f);
        student8.setEmail("jane.doe@example.org");
        student8.setFirstName("Jane");
        student8.setLastName("Doe");
        student8.setRemainingCourses(1);
        student8.setStudentId(1);
        student8.setUser(user6);
        User user7 = mock(User.class);
        when(user7.getStudent()).thenReturn(student8);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user7, "Credentials");

        Professor professor7 = new Professor();
        professor7.setEmail("jane.doe@example.org");
        professor7.setFirstName("Jane");
        professor7.setLastName("Doe");
        professor7.setPId(1);
        professor7.setUser(new User());

        Student student9 = new Student();
        student9.setApplications(new ArrayList<>());
        student9.setAverageGrade(10.0f);
        student9.setEmail("jane.doe@example.org");
        student9.setFirstName("Jane");
        student9.setLastName("Doe");
        student9.setRemainingCourses(1);
        student9.setStudentId(1);
        student9.setUser(new User());

        User user8 = new User();
        user8.setId(1);
        user8.setPassword("iloveyou");
        user8.setProfessor(professor7);
        user8.setRole(Role.STUDENT);
        user8.setStudent(student9);
        user8.setUsername("janedoe");

        Professor professor8 = new Professor();
        professor8.setEmail("jane.doe@example.org");
        professor8.setFirstName("Jane");
        professor8.setLastName("Doe");
        professor8.setPId(1);
        professor8.setUser(user8);

        Professor professor9 = new Professor();
        professor9.setEmail("jane.doe@example.org");
        professor9.setFirstName("Jane");
        professor9.setLastName("Doe");
        professor9.setPId(1);
        professor9.setUser(new User());

        Student student10 = new Student();
        student10.setApplications(new ArrayList<>());
        student10.setAverageGrade(10.0f);
        student10.setEmail("jane.doe@example.org");
        student10.setFirstName("Jane");
        student10.setLastName("Doe");
        student10.setRemainingCourses(1);
        student10.setStudentId(1);
        student10.setUser(new User());

        User user9 = new User();
        user9.setId(1);
        user9.setPassword("iloveyou");
        user9.setProfessor(professor9);
        user9.setRole(Role.STUDENT);
        user9.setStudent(student10);
        user9.setUsername("janedoe");

        Student student11 = new Student();
        student11.setApplications(new ArrayList<>());
        student11.setAverageGrade(10.0f);
        student11.setEmail("jane.doe@example.org");
        student11.setFirstName("Jane");
        student11.setLastName("Doe");
        student11.setRemainingCourses(1);
        student11.setStudentId(1);
        student11.setUser(user9);

        User user10 = new User();
        user10.setId(1);
        user10.setPassword("iloveyou");
        user10.setProfessor(professor8);
        user10.setRole(Role.STUDENT);
        user10.setStudent(student11);
        user10.setUsername("janedoe");

        Student theStudent = new Student();
        theStudent.setApplications(new ArrayList<>());
        theStudent.setAverageGrade(10.0f);
        theStudent.setEmail("jane.doe@example.org");
        theStudent.setFirstName("Jane");
        theStudent.setLastName("Doe");
        theStudent.setRemainingCourses(1);
        theStudent.setStudentId(1);
        theStudent.setUser(user10);
        assertEquals("redirect:/student/dashboard", studentController.saveDetails(authentication, theStudent));
        verify(theStudentRepository).save(Mockito.<Student>any());
        verify(user7).getStudent();
    }

    /**
     * Method under test: {@link StudentController#saveDetails(Authentication, Student)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveDetails5() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.saveDetails(StudentController.java:76)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.service.StudentServiceImpl.save(StudentServiceImpl.java:84)
        //       at org.uoi.diploma_management_application.controller.StudentController.saveDetails(StudentController.java:81)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(professor);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(new User());

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(professor3);
        user2.setRole(Role.STUDENT);
        user2.setStudent(student2);
        user2.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor2);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");
        Student student4 = mock(Student.class);
        doNothing().when(student4).copyFields(Mockito.<Student>any());
        doNothing().when(student4).setApplications(Mockito.<List<Application>>any());
        doNothing().when(student4).setAverageGrade(anyFloat());
        doNothing().when(student4).setEmail(Mockito.<String>any());
        doNothing().when(student4).setFirstName(Mockito.<String>any());
        doNothing().when(student4).setLastName(Mockito.<String>any());
        doNothing().when(student4).setRemainingCourses(anyInt());
        doNothing().when(student4).setStudentId(anyInt());
        doNothing().when(student4).setUser(Mockito.<User>any());
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);
        User user4 = mock(User.class);
        when(user4.getStudent()).thenReturn(student4);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user4, "Credentials");

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(new User());

        Student student5 = new Student();
        student5.setApplications(new ArrayList<>());
        student5.setAverageGrade(10.0f);
        student5.setEmail("jane.doe@example.org");
        student5.setFirstName("Jane");
        student5.setLastName("Doe");
        student5.setRemainingCourses(1);
        student5.setStudentId(1);
        student5.setUser(new User());

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(professor4);
        user5.setRole(Role.STUDENT);
        user5.setStudent(student5);
        user5.setUsername("janedoe");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(user5);

        Professor professor6 = new Professor();
        professor6.setEmail("jane.doe@example.org");
        professor6.setFirstName("Jane");
        professor6.setLastName("Doe");
        professor6.setPId(1);
        professor6.setUser(new User());

        Student student6 = new Student();
        student6.setApplications(new ArrayList<>());
        student6.setAverageGrade(10.0f);
        student6.setEmail("jane.doe@example.org");
        student6.setFirstName("Jane");
        student6.setLastName("Doe");
        student6.setRemainingCourses(1);
        student6.setStudentId(1);
        student6.setUser(new User());

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor6);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student6);
        user6.setUsername("janedoe");

        Student student7 = new Student();
        student7.setApplications(new ArrayList<>());
        student7.setAverageGrade(10.0f);
        student7.setEmail("jane.doe@example.org");
        student7.setFirstName("Jane");
        student7.setLastName("Doe");
        student7.setRemainingCourses(1);
        student7.setStudentId(1);
        student7.setUser(user6);

        User user7 = new User();
        user7.setId(1);
        user7.setPassword("iloveyou");
        user7.setProfessor(professor5);
        user7.setRole(Role.STUDENT);
        user7.setStudent(student7);
        user7.setUsername("janedoe");

        Student theStudent = new Student();
        theStudent.setApplications(new ArrayList<>());
        theStudent.setAverageGrade(10.0f);
        theStudent.setEmail("jane.doe@example.org");
        theStudent.setFirstName("Jane");
        theStudent.setLastName("Doe");
        theStudent.setRemainingCourses(1);
        theStudent.setStudentId(1);
        theStudent.setUser(user7);
        studentController.saveDetails(authentication, theStudent);
    }

    /**
     * Method under test: {@link StudentController#saveDetails(Authentication, Student)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveDetails6() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.saveDetails(StudentController.java:76)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.StudentController.saveDetails(StudentController.java:76)
        //   See https://diff.blue/R013 to resolve this issue.

        StudentController studentController = new StudentController(new StudentServiceImpl());

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        User user = new User();
        user.setId(1);
        user.setPassword("iloveyou");
        user.setProfessor(professor);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(user);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(new User());

        User user2 = new User();
        user2.setId(1);
        user2.setPassword("iloveyou");
        user2.setProfessor(professor3);
        user2.setRole(Role.STUDENT);
        user2.setStudent(student2);
        user2.setUsername("janedoe");

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(user2);

        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor2);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");
        Student student4 = mock(Student.class);
        doNothing().when(student4).copyFields(Mockito.<Student>any());
        doNothing().when(student4).setApplications(Mockito.<List<Application>>any());
        doNothing().when(student4).setAverageGrade(anyFloat());
        doNothing().when(student4).setEmail(Mockito.<String>any());
        doNothing().when(student4).setFirstName(Mockito.<String>any());
        doNothing().when(student4).setLastName(Mockito.<String>any());
        doNothing().when(student4).setRemainingCourses(anyInt());
        doNothing().when(student4).setStudentId(anyInt());
        doNothing().when(student4).setUser(Mockito.<User>any());
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(new User());

        Student student5 = new Student();
        student5.setApplications(new ArrayList<>());
        student5.setAverageGrade(10.0f);
        student5.setEmail("jane.doe@example.org");
        student5.setFirstName("Jane");
        student5.setLastName("Doe");
        student5.setRemainingCourses(1);
        student5.setStudentId(1);
        student5.setUser(new User());

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(professor4);
        user4.setRole(Role.STUDENT);
        user4.setStudent(student5);
        user4.setUsername("janedoe");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(user4);

        Professor professor6 = new Professor();
        professor6.setEmail("jane.doe@example.org");
        professor6.setFirstName("Jane");
        professor6.setLastName("Doe");
        professor6.setPId(1);
        professor6.setUser(new User());

        Student student6 = new Student();
        student6.setApplications(new ArrayList<>());
        student6.setAverageGrade(10.0f);
        student6.setEmail("jane.doe@example.org");
        student6.setFirstName("Jane");
        student6.setLastName("Doe");
        student6.setRemainingCourses(1);
        student6.setStudentId(1);
        student6.setUser(new User());

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(professor6);
        user5.setRole(Role.STUDENT);
        user5.setStudent(student6);
        user5.setUsername("janedoe");

        Student student7 = new Student();
        student7.setApplications(new ArrayList<>());
        student7.setAverageGrade(10.0f);
        student7.setEmail("jane.doe@example.org");
        student7.setFirstName("Jane");
        student7.setLastName("Doe");
        student7.setRemainingCourses(1);
        student7.setStudentId(1);
        student7.setUser(user5);

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor5);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student7);
        user6.setUsername("janedoe");

        Student theStudent = new Student();
        theStudent.setApplications(new ArrayList<>());
        theStudent.setAverageGrade(10.0f);
        theStudent.setEmail("jane.doe@example.org");
        theStudent.setFirstName("Jane");
        theStudent.setLastName("Doe");
        theStudent.setRemainingCourses(1);
        theStudent.setStudentId(1);
        theStudent.setUser(user6);
        studentController.saveDetails(null, theStudent);
    }
}

