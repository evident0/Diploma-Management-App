package org.uoi.diploma_management_application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.context.support.WithSecurityContext;
import org.springframework.security.test.context.support.WithUserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.ConcurrentModel;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;
import org.uoi.diploma_management_application.dao.ApplicationDAO;
import org.uoi.diploma_management_application.dao.ProfessorDAO;
import org.uoi.diploma_management_application.dao.SubjectDAO;
import org.uoi.diploma_management_application.dao.ThesisDAO;
import org.uoi.diploma_management_application.entity.Professor;
import org.uoi.diploma_management_application.entity.Role;
import org.uoi.diploma_management_application.entity.Student;
import org.uoi.diploma_management_application.entity.Subject;
import org.uoi.diploma_management_application.entity.Thesis;
import org.uoi.diploma_management_application.entity.User;
import org.uoi.diploma_management_application.service.ProfessorService;
import org.uoi.diploma_management_application.service.ProfessorServiceImpl;

@ContextConfiguration(classes = {ProfessorController.class})
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@SpringBootTest
@TestPropertySource(
        locations = "classpath:application.properties")
class ProfessorControllerTest {
    @Autowired
    private ProfessorController professorController;

    //@MockBean
    //private Authentication authentication;

    @MockBean
    private ProfessorService professorService;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private WebApplicationContext context;

    @BeforeEach
    public void setup() {
        mockMvc = MockMvcBuilders
                .webAppContextSetup(context)
                .build();
    }

    /**
     * Method under test: {@link ProfessorController#getProfessorHome(Authentication, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetProfessorHome() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.ProfessorController.getProfessorHome(ProfessorController.java:30)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.service.ProfessorServiceImpl.findById(ProfessorServiceImpl.java:51)
        //       at org.uoi.diploma_management_application.controller.ProfessorController.getProfessorHome(ProfessorController.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl());

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

        professorController.getProfessorHome(authentication, new ConcurrentModel());
    }

    /**
     * Method under test: {@link ProfessorController#getProfessorHome(Authentication, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetProfessorHome2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.ProfessorController.getProfessorHome(ProfessorController.java:30)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.ProfessorController.getProfessorHome(ProfessorController.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl());
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(null, "Credentials");

        professorController.getProfessorHome(authentication, new ConcurrentModel());
    }

    /**
     * Method under test: {@link ProfessorController#getProfessorHome(Authentication, Model)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testGetProfessorHome3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.ProfessorController.getProfessorHome(ProfessorController.java:30)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.service.ProfessorServiceImpl.findById(ProfessorServiceImpl.java:51)
        //       at org.uoi.diploma_management_application.controller.ProfessorController.getProfessorHome(ProfessorController.java:31)
        //   See https://diff.blue/R013 to resolve this issue.

        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl());

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

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(user3);
        User user4 = mock(User.class);
        when(user4.getProfessor()).thenReturn(professor4);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user4, "Credentials");

        professorController.getProfessorHome(authentication, new ConcurrentModel());
    }

    /**
     * Method under test: {@link ProfessorController#getProfessorHome(Authentication, Model)}
     */
    @Test
    void testGetProfessorHome4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.ProfessorController.getProfessorHome(ProfessorController.java:30)
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

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(user3);
        ProfessorDAO theProfessorRepository = mock(ProfessorDAO.class);
        when(theProfessorRepository.findById(anyInt())).thenReturn(professor4);
        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl(theProfessorRepository,
                mock(SubjectDAO.class), mock(ThesisDAO.class), mock(ApplicationDAO.class)));

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(new User());

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(new User());

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(professor5);
        user4.setRole(Role.STUDENT);
        user4.setStudent(student4);
        user4.setUsername("janedoe");

        Professor professor6 = new Professor();
        professor6.setEmail("jane.doe@example.org");
        professor6.setFirstName("Jane");
        professor6.setLastName("Doe");
        professor6.setPId(1);
        professor6.setUser(user4);

        Professor professor7 = new Professor();
        professor7.setEmail("jane.doe@example.org");
        professor7.setFirstName("Jane");
        professor7.setLastName("Doe");
        professor7.setPId(1);
        professor7.setUser(new User());

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
        user5.setProfessor(professor7);
        user5.setRole(Role.STUDENT);
        user5.setStudent(student5);
        user5.setUsername("janedoe");

        Student student6 = new Student();
        student6.setApplications(new ArrayList<>());
        student6.setAverageGrade(10.0f);
        student6.setEmail("jane.doe@example.org");
        student6.setFirstName("Jane");
        student6.setLastName("Doe");
        student6.setRemainingCourses(1);
        student6.setStudentId(1);
        student6.setUser(user5);

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor6);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student6);
        user6.setUsername("janedoe");

        Professor professor8 = new Professor();
        professor8.setEmail("jane.doe@example.org");
        professor8.setFirstName("Jane");
        professor8.setLastName("Doe");
        professor8.setPId(1);
        professor8.setUser(user6);
        User user7 = mock(User.class);
        doNothing().when(user7).setProfessor(Mockito.<Professor>any());
        when(user7.getProfessor()).thenReturn(professor8);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user7, "Credentials");

        assertEquals("professor/dashboard", professorController.getProfessorHome(authentication, new ConcurrentModel()));
        verify(theProfessorRepository).findById(anyInt());
        verify(user7, atLeast(1)).getProfessor();
        verify(user7).setProfessor(Mockito.<Professor>any());
    }

    /**
     * Method under test: {@link ProfessorController#saveSubject(Authentication, Subject)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveSubject() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.ProfessorController.saveSubject(ProfessorController.java:55)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.service.ProfessorServiceImpl.saveSubject(ProfessorServiceImpl.java:121)
        //       at org.uoi.diploma_management_application.controller.ProfessorController.saveSubject(ProfessorController.java:58)
        //   See https://diff.blue/R013 to resolve this issue.

        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl());

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

        User user8 = new User();
        user8.setId(1);
        user8.setPassword("iloveyou");
        user8.setProfessor(new Professor());
        user8.setRole(Role.STUDENT);
        user8.setStudent(new Student());
        user8.setUsername("janedoe");

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(user8);

        User user9 = new User();
        user9.setId(1);
        user9.setPassword("iloveyou");
        user9.setProfessor(new Professor());
        user9.setRole(Role.STUDENT);
        user9.setStudent(new Student());
        user9.setUsername("janedoe");

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user9);

        User user10 = new User();
        user10.setId(1);
        user10.setPassword("iloveyou");
        user10.setProfessor(professor4);
        user10.setRole(Role.STUDENT);
        user10.setStudent(student4);
        user10.setUsername("janedoe");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(user10);

        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");

        Subject theSubject = new Subject();
        theSubject.setDescription("The characteristics of someone or something");
        theSubject.setProfessor(professor5);
        theSubject.setSubjectId(1);
        theSubject.setThesis(thesis);
        theSubject.setTitle("Dr");
        professorController.saveSubject(authentication, theSubject);
    }

    /**
     * Method under test: {@link ProfessorController#saveSubject(Authentication, Subject)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveSubject2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.ProfessorController.saveSubject(ProfessorController.java:55)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.ProfessorController.saveSubject(ProfessorController.java:56)
        //   See https://diff.blue/R013 to resolve this issue.

        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl());
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(null, "Credentials");

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

        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");

        Subject theSubject = new Subject();
        theSubject.setDescription("The characteristics of someone or something");
        theSubject.setProfessor(professor2);
        theSubject.setSubjectId(1);
        theSubject.setThesis(thesis);
        theSubject.setTitle("Dr");
        professorController.saveSubject(authentication, theSubject);
    }

    /**
     * Method under test: {@link ProfessorController#saveSubject(Authentication, Subject)}
     */
    @Test
    @Disabled("TODO: Complete this test")
    void testSaveSubject3() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.ProfessorController.saveSubject(ProfessorController.java:55)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.service.ProfessorServiceImpl.saveSubject(ProfessorServiceImpl.java:121)
        //       at org.uoi.diploma_management_application.controller.ProfessorController.saveSubject(ProfessorController.java:58)
        //   See https://diff.blue/R013 to resolve this issue.

        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl());

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

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(user3);
        User user4 = mock(User.class);
        when(user4.getProfessor()).thenReturn(professor4);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user4, "Credentials");

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(new Professor());
        user5.setRole(Role.STUDENT);
        user5.setStudent(new Student());
        user5.setUsername("janedoe");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(user5);

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(new Professor());
        user6.setRole(Role.STUDENT);
        user6.setStudent(new Student());
        user6.setUsername("janedoe");

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user6);

        User user7 = new User();
        user7.setId(1);
        user7.setPassword("iloveyou");
        user7.setProfessor(professor5);
        user7.setRole(Role.STUDENT);
        user7.setStudent(student4);
        user7.setUsername("janedoe");

        Professor professor6 = new Professor();
        professor6.setEmail("jane.doe@example.org");
        professor6.setFirstName("Jane");
        professor6.setLastName("Doe");
        professor6.setPId(1);
        professor6.setUser(user7);

        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");

        Subject theSubject = new Subject();
        theSubject.setDescription("The characteristics of someone or something");
        theSubject.setProfessor(professor6);
        theSubject.setSubjectId(1);
        theSubject.setThesis(thesis);
        theSubject.setTitle("Dr");
        professorController.saveSubject(authentication, theSubject);
    }

    /**
     * Method under test: {@link ProfessorController#saveSubject(Authentication, Subject)}
     */
    @Test
    void testSaveSubject4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.ProfessorController.saveSubject(ProfessorController.java:55)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

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

        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");

        Subject subject = new Subject();
        subject.setDescription("The characteristics of someone or something");
        subject.setProfessor(professor2);
        subject.setSubjectId(1);
        subject.setThesis(thesis);
        subject.setTitle("Dr");
        SubjectDAO theSubjectRepository = mock(SubjectDAO.class);
        when(theSubjectRepository.save(Mockito.<Subject>any())).thenReturn(subject);
        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl(
                mock(ProfessorDAO.class), theSubjectRepository, mock(ThesisDAO.class), mock(ApplicationDAO.class)));

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

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(professor3);
        user4.setRole(Role.STUDENT);
        user4.setStudent(student2);
        user4.setUsername("janedoe");

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(user4);

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(new User());

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(new User());

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(professor5);
        user5.setRole(Role.STUDENT);
        user5.setStudent(student3);
        user5.setUsername("janedoe");

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user5);

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor4);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student4);
        user6.setUsername("janedoe");

        Professor professor6 = new Professor();
        professor6.setEmail("jane.doe@example.org");
        professor6.setFirstName("Jane");
        professor6.setLastName("Doe");
        professor6.setPId(1);
        professor6.setUser(user6);
        User user7 = mock(User.class);
        when(user7.getProfessor()).thenReturn(professor6);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user7, "Credentials");

        User user8 = new User();
        user8.setId(1);
        user8.setPassword("iloveyou");
        user8.setProfessor(new Professor());
        user8.setRole(Role.STUDENT);
        user8.setStudent(new Student());
        user8.setUsername("janedoe");

        Professor professor7 = new Professor();
        professor7.setEmail("jane.doe@example.org");
        professor7.setFirstName("Jane");
        professor7.setLastName("Doe");
        professor7.setPId(1);
        professor7.setUser(user8);

        User user9 = new User();
        user9.setId(1);
        user9.setPassword("iloveyou");
        user9.setProfessor(new Professor());
        user9.setRole(Role.STUDENT);
        user9.setStudent(new Student());
        user9.setUsername("janedoe");

        Student student5 = new Student();
        student5.setApplications(new ArrayList<>());
        student5.setAverageGrade(10.0f);
        student5.setEmail("jane.doe@example.org");
        student5.setFirstName("Jane");
        student5.setLastName("Doe");
        student5.setRemainingCourses(1);
        student5.setStudentId(1);
        student5.setUser(user9);

        User user10 = new User();
        user10.setId(1);
        user10.setPassword("iloveyou");
        user10.setProfessor(professor7);
        user10.setRole(Role.STUDENT);
        user10.setStudent(student5);
        user10.setUsername("janedoe");

        Professor professor8 = new Professor();
        professor8.setEmail("jane.doe@example.org");
        professor8.setFirstName("Jane");
        professor8.setLastName("Doe");
        professor8.setPId(1);
        professor8.setUser(user10);

        Thesis thesis2 = new Thesis();
        thesis2.setDescription("The characteristics of someone or something");
        thesis2.setGrade(10.0f);
        thesis2.setTId(1);
        thesis2.setTitle("Dr");

        Subject theSubject = new Subject();
        theSubject.setDescription("The characteristics of someone or something");
        theSubject.setProfessor(professor8);
        theSubject.setSubjectId(1);
        theSubject.setThesis(thesis2);
        theSubject.setTitle("Dr");
        assertEquals("redirect:/professor/dashboard", professorController.saveSubject(authentication, theSubject));
        verify(theSubjectRepository).save(Mockito.<Subject>any());
        verify(user7).getProfessor();
        assertSame(professor6, theSubject.getProfessor());
    }

    /**
     * Method under test: {@link ProfessorController#changeDetails(Authentication, Model)}
     */
    @Test
    void testChangeDetails() {

        TestingAuthenticationToken authentication = new TestingAuthenticationToken(new User(), "Credentials");

        assertEquals("professor/professor-details",
                professorController.changeDetails(authentication, new ConcurrentModel()));
    }


    /**
     * Method under test: {@link ProfessorController#saveDetails(Authentication, Professor)}
     */
    public @interface WithMockUser {
        String value() default "user";

        String username() default "";

        String[] roles() default {"PROFESSOR"};

        String password() default "password";
    }



    public interface WithSecurityContextFactory<A extends Annotation> {

        SecurityContext createSecurityContext(A annotation);
    }

/*
    @Test
    @WithMockUser(roles="PROFESSOR")
    @WithSecurityContext(
            //factory = WithMockUserSecurityContextFactory.class
    )*/
    void testSaveDetails() throws Exception {

        Professor professor = new Professor("Bob", "Mastoras", "bob@mail");

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("pId", Integer.toString(professor.getPId()));
        multiValueMap.add("firstName", professor.getFirstName());
        multiValueMap.add("lastName", professor.getLastName());
        multiValueMap.add("email", professor.getEmail());
        //when((User) authentication.getPrincipal()).thenReturn(new User());
        mockMvc.perform(
                        post("/professor/save_details")
                                .params(multiValueMap))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/professor/dashboard"));
/*
        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.post("/professor/save_details")
                .params(multiValueMap);
        System.out.println("sdffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"+paramResult);
        MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(paramResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/professor/dashboard"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/professor/dashboard"));
*/
    }

    /**
     * Method under test: {@link ProfessorController#saveDetails(Authentication, Professor)}
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
        //       at org.uoi.diploma_management_application.controller.ProfessorController.saveDetails(ProfessorController.java:87)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.ProfessorController.saveDetails(ProfessorController.java:88)
        //   See https://diff.blue/R013 to resolve this issue.

        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl());
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

        Professor theProfessor = new Professor();
        theProfessor.setEmail("jane.doe@example.org");
        theProfessor.setFirstName("Jane");
        theProfessor.setLastName("Doe");
        theProfessor.setPId(1);
        theProfessor.setUser(user3);
        professorController.saveDetails(authentication, theProfessor);
    }

    /**
     * Method under test: {@link ProfessorController#saveDetails(Authentication, Professor)}
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
        //       at org.uoi.diploma_management_application.controller.ProfessorController.saveDetails(ProfessorController.java:87)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        // TODO: Complete this test.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.service.ProfessorServiceImpl.save(ProfessorServiceImpl.java:109)
        //       at org.uoi.diploma_management_application.controller.ProfessorController.saveDetails(ProfessorController.java:92)
        //   See https://diff.blue/R013 to resolve this issue.

        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl());

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

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(user3);
        User user4 = mock(User.class);
        when(user4.getProfessor()).thenReturn(professor4);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user4, "Credentials");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(new User());

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(new User());

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(professor5);
        user5.setRole(Role.STUDENT);
        user5.setStudent(student4);
        user5.setUsername("janedoe");

        Professor professor6 = new Professor();
        professor6.setEmail("jane.doe@example.org");
        professor6.setFirstName("Jane");
        professor6.setLastName("Doe");
        professor6.setPId(1);
        professor6.setUser(user5);

        Professor professor7 = new Professor();
        professor7.setEmail("jane.doe@example.org");
        professor7.setFirstName("Jane");
        professor7.setLastName("Doe");
        professor7.setPId(1);
        professor7.setUser(new User());

        Student student5 = new Student();
        student5.setApplications(new ArrayList<>());
        student5.setAverageGrade(10.0f);
        student5.setEmail("jane.doe@example.org");
        student5.setFirstName("Jane");
        student5.setLastName("Doe");
        student5.setRemainingCourses(1);
        student5.setStudentId(1);
        student5.setUser(new User());

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor7);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student5);
        user6.setUsername("janedoe");

        Student student6 = new Student();
        student6.setApplications(new ArrayList<>());
        student6.setAverageGrade(10.0f);
        student6.setEmail("jane.doe@example.org");
        student6.setFirstName("Jane");
        student6.setLastName("Doe");
        student6.setRemainingCourses(1);
        student6.setStudentId(1);
        student6.setUser(user6);

        User user7 = new User();
        user7.setId(1);
        user7.setPassword("iloveyou");
        user7.setProfessor(professor6);
        user7.setRole(Role.STUDENT);
        user7.setStudent(student6);
        user7.setUsername("janedoe");

        Professor theProfessor = new Professor();
        theProfessor.setEmail("jane.doe@example.org");
        theProfessor.setFirstName("Jane");
        theProfessor.setLastName("Doe");
        theProfessor.setPId(1);
        theProfessor.setUser(user7);
        professorController.saveDetails(authentication, theProfessor);
    }

    /**
     * Method under test: {@link ProfessorController#saveDetails(Authentication, Professor)}
     */
    @Test
    void testSaveDetails4() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   java.lang.NullPointerException
        //       at org.uoi.diploma_management_application.controller.ProfessorController.saveDetails(ProfessorController.java:87)
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

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(user3);
        ProfessorDAO theProfessorRepository = mock(ProfessorDAO.class);
        when(theProfessorRepository.save(Mockito.<Professor>any())).thenReturn(professor4);
        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl(theProfessorRepository,
                mock(SubjectDAO.class), mock(ThesisDAO.class), mock(ApplicationDAO.class)));

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(new User());

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(new User());

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(professor5);
        user4.setRole(Role.STUDENT);
        user4.setStudent(student4);
        user4.setUsername("janedoe");

        Professor professor6 = new Professor();
        professor6.setEmail("jane.doe@example.org");
        professor6.setFirstName("Jane");
        professor6.setLastName("Doe");
        professor6.setPId(1);
        professor6.setUser(user4);

        Professor professor7 = new Professor();
        professor7.setEmail("jane.doe@example.org");
        professor7.setFirstName("Jane");
        professor7.setLastName("Doe");
        professor7.setPId(1);
        professor7.setUser(new User());

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
        user5.setProfessor(professor7);
        user5.setRole(Role.STUDENT);
        user5.setStudent(student5);
        user5.setUsername("janedoe");

        Student student6 = new Student();
        student6.setApplications(new ArrayList<>());
        student6.setAverageGrade(10.0f);
        student6.setEmail("jane.doe@example.org");
        student6.setFirstName("Jane");
        student6.setLastName("Doe");
        student6.setRemainingCourses(1);
        student6.setStudentId(1);
        student6.setUser(user5);

        User user6 = new User();
        user6.setId(1);
        user6.setPassword("iloveyou");
        user6.setProfessor(professor6);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student6);
        user6.setUsername("janedoe");

        Professor professor8 = new Professor();
        professor8.setEmail("jane.doe@example.org");
        professor8.setFirstName("Jane");
        professor8.setLastName("Doe");
        professor8.setPId(1);
        professor8.setUser(user6);
        User user7 = mock(User.class);
        when(user7.getProfessor()).thenReturn(professor8);
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user7, "Credentials");

        Professor professor9 = new Professor();
        professor9.setEmail("jane.doe@example.org");
        professor9.setFirstName("Jane");
        professor9.setLastName("Doe");
        professor9.setPId(1);
        professor9.setUser(new User());

        Student student7 = new Student();
        student7.setApplications(new ArrayList<>());
        student7.setAverageGrade(10.0f);
        student7.setEmail("jane.doe@example.org");
        student7.setFirstName("Jane");
        student7.setLastName("Doe");
        student7.setRemainingCourses(1);
        student7.setStudentId(1);
        student7.setUser(new User());

        User user8 = new User();
        user8.setId(1);
        user8.setPassword("iloveyou");
        user8.setProfessor(professor9);
        user8.setRole(Role.STUDENT);
        user8.setStudent(student7);
        user8.setUsername("janedoe");

        Professor professor10 = new Professor();
        professor10.setEmail("jane.doe@example.org");
        professor10.setFirstName("Jane");
        professor10.setLastName("Doe");
        professor10.setPId(1);
        professor10.setUser(user8);

        Professor professor11 = new Professor();
        professor11.setEmail("jane.doe@example.org");
        professor11.setFirstName("Jane");
        professor11.setLastName("Doe");
        professor11.setPId(1);
        professor11.setUser(new User());

        Student student8 = new Student();
        student8.setApplications(new ArrayList<>());
        student8.setAverageGrade(10.0f);
        student8.setEmail("jane.doe@example.org");
        student8.setFirstName("Jane");
        student8.setLastName("Doe");
        student8.setRemainingCourses(1);
        student8.setStudentId(1);
        student8.setUser(new User());

        User user9 = new User();
        user9.setId(1);
        user9.setPassword("iloveyou");
        user9.setProfessor(professor11);
        user9.setRole(Role.STUDENT);
        user9.setStudent(student8);
        user9.setUsername("janedoe");

        Student student9 = new Student();
        student9.setApplications(new ArrayList<>());
        student9.setAverageGrade(10.0f);
        student9.setEmail("jane.doe@example.org");
        student9.setFirstName("Jane");
        student9.setLastName("Doe");
        student9.setRemainingCourses(1);
        student9.setStudentId(1);
        student9.setUser(user9);

        User user10 = new User();
        user10.setId(1);
        user10.setPassword("iloveyou");
        user10.setProfessor(professor10);
        user10.setRole(Role.STUDENT);
        user10.setStudent(student9);
        user10.setUsername("janedoe");

        Professor theProfessor = new Professor();
        theProfessor.setEmail("jane.doe@example.org");
        theProfessor.setFirstName("Jane");
        theProfessor.setLastName("Doe");
        theProfessor.setPId(1);
        theProfessor.setUser(user10);
        assertEquals("redirect:/professor/dashboard", professorController.saveDetails(authentication, theProfessor));
        verify(theProfessorRepository).save(Mockito.<Professor>any());
        verify(user7).getProfessor();
    }



    /**
     * Method under test: {@link ProfessorController#updateGrade(int, Model)}
     */
    @Test
    void testUpdateGrade2() {
        //   Diffblue Cover was unable to write a Spring test,
        //   so wrote a non-Spring test instead.
        //   Reason: R013 No inputs found that don't throw a trivial exception.
        //   Diffblue Cover tried to run the arrange/act section, but the method under
        //   test threw
        //   javax.servlet.ServletException: Circular view path [/professor/update-grade]: would dispatch back to the current handler URL [/professor/update-grade] again. Check your ViewResolver setup! (Hint: This may be the result of an unspecified view, due to default view name generation.)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:655)
        //       at javax.servlet.http.HttpServlet.service(HttpServlet.java:764)
        //   See https://diff.blue/R013 to resolve this issue.

        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl(
                mock(ProfessorDAO.class), mock(SubjectDAO.class), mock(ThesisDAO.class), mock(ApplicationDAO.class)));
        assertEquals("/professor/update-grade", professorController.updateGrade(1, new ConcurrentModel()));
    }

    /**
     * Method under test: {@link ProfessorController#createSubject(Authentication, Model)}
     */
    @Test
    void testCreateSubject() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/professor/create-subject");
        MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("subject"))
                .andExpect(view().name("professor/create-subject"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("professor/create-subject"));
    }

    /**
     * Method under test: {@link ProfessorController#createSubject(Authentication, Model)}
     */
    @Test
    void testCreateSubject2() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/professor/create-subject");
        requestBuilder.characterEncoding("Encoding");
        MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(MockMvcResultMatchers.model().size(1))
                .andExpect(MockMvcResultMatchers.model().attributeExists("subject"))
                .andExpect(view().name("professor/create-subject"))
                .andExpect(MockMvcResultMatchers.forwardedUrl("professor/create-subject"));
    }

    /**
     * Method under test: {@link ProfessorController#deleteSubject(int)}
     */
    @Test
    void testDeleteSubject() throws Exception {
        doNothing().when(professorService).deleteSubjectById(anyInt());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/professor/delete-subject");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("subjectId", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(view().name("redirect:/professor/dashboard"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/professor/dashboard"));
    }

    /**
     * Method under test: {@link ProfessorController#pickByThresholds(float, int, int)}
     */
    @Test
    void testPickByThresholds() throws Exception {
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

        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");

        Subject subject = new Subject();
        subject.setDescription("The characteristics of someone or something");
        subject.setProfessor(professor2);
        subject.setSubjectId(1);
        subject.setThesis(thesis);
        subject.setTitle("Dr");
        when(professorService.assignThesis(Mockito.<Student>any(), Mockito.<Subject>any())).thenReturn(1);
        when(professorService.findStudentsBySubjectId(anyInt())).thenReturn(new ArrayList<>());
        when(professorService.findSubjectById(anyInt())).thenReturn(subject);
        MockHttpServletRequestBuilder postResult = post("/professor/pick-bythresholds");
        MockHttpServletRequestBuilder paramResult = postResult.param("subjectId", String.valueOf(1));
        MockHttpServletRequestBuilder paramResult2 = paramResult.param("th1", String.valueOf(10.0f));
        MockHttpServletRequestBuilder requestBuilder = paramResult2.param("th2", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(view().name("redirect:/professor/dashboard"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/professor/dashboard"));
    }

    /**
     * Method under test: {@link ProfessorController#pickStudent(String, int)}
     */
    @Test
    void testPickStudent() throws Exception {
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

        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");

        Subject subject = new Subject();
        subject.setDescription("The characteristics of someone or something");
        subject.setProfessor(professor2);
        subject.setSubjectId(1);
        subject.setThesis(thesis);
        subject.setTitle("Dr");
        when(professorService.assignThesis(Mockito.<Student>any(), Mockito.<Subject>any())).thenReturn(1);
        when(professorService.findStudentsBySubjectId(anyInt())).thenReturn(new ArrayList<>());
        when(professorService.findSubjectById(anyInt())).thenReturn(subject);
        MockHttpServletRequestBuilder paramResult = post("/professor/pick-student")
                .param("pickMethod", "foo");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("subjectId", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(view().name("redirect:/professor/dashboard"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/professor/dashboard"));
    }

    /**
     * Method under test: {@link ProfessorController#pickStudent(String, int)}
     */
    @Test
    void testPickStudent2() throws Exception {

        MockHttpServletRequestBuilder paramResult = post("/professor/pick-student")
                .param("pickMethod", "default");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("subjectId", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(view().name("redirect:/professor/dashboard"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/professor/dashboard"));
    }

    /**
     * Method under test: {@link ProfessorController#pickStudent(String, int)}
     */
    @Test
    void testPickStudent3() throws Exception {

        MockHttpServletRequestBuilder paramResult = post("/professor/pick-student")
                .param("pickMethod", "bestAVG");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("subjectId", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(view().name("redirect:/professor/dashboard"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/professor/dashboard"));
    }

    /**
     * Method under test: {@link ProfessorController#saveGrade(int, float, float, float)}
     */
    @Test
    void testSaveGrade() throws Exception {
        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");
        when(professorService.calculateGrade(anyFloat(), anyFloat(), anyFloat())).thenReturn(10.0f);
        when(professorService.findThesisById(anyInt())).thenReturn(thesis);
        doNothing().when(professorService).saveThesisGrade(Mockito.<Thesis>any(), anyFloat());
        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/professor/save-grade");
        MockHttpServletRequestBuilder paramResult = getResult.param("gradeI", String.valueOf(10.0f));
        MockHttpServletRequestBuilder paramResult2 = paramResult.param("gradeP", String.valueOf(10.0f));
        MockHttpServletRequestBuilder paramResult3 = paramResult2.param("gradeR", String.valueOf(10.0f));
        MockHttpServletRequestBuilder requestBuilder = paramResult3.param("thesisId", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(view().name("redirect:/professor/dashboard"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/professor/dashboard"));
    }

    /**
     * Method under test: {@link ProfessorController#viewApplications(int, Model)}
     */
    @Test
    void testViewApplications() throws Exception {
        when(professorService.findStudentsBySubjectId(anyInt())).thenReturn(new ArrayList<>());
        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.get("/professor/applications")
                .param("subjectId", "https://example.org/example");
        ResultActions actualPerformResult = MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(requestBuilder);
        actualPerformResult.andExpect(status().is(400));
    }
}

