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
    void testGetUserHome() {
        StudentDAO theStudentRepository = mock(StudentDAO.class);
        when(theStudentRepository.findById(anyInt())).thenReturn(new Student());
        SubjectDAO subjectDAO = mock(SubjectDAO.class);
        when(subjectDAO.findAll()).thenReturn(new ArrayList<>());
        StudentController studentController = new StudentController(
                new StudentServiceImpl(theStudentRepository, mock(SubjectDAO.class), mock(ApplicationDAO.class), subjectDAO));

        User user = mock(User.class);
        doNothing().when(user).setStudent(Mockito.<Student>any());
        when(user.getStudent()).thenReturn(new Student());
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user, "Credentials");

        assertEquals("student/dashboard", studentController.getUserHome(authentication, new ConcurrentModel()));
        verify(theStudentRepository).findById(anyInt());
        verify(subjectDAO).findAll();
        verify(user, atLeast(1)).getStudent();
        verify(user).setStudent(Mockito.<Student>any());
    }

    /**
     * Method under test: {@link StudentController#getUserAvailableSubjects(Authentication, Model)}
     */
    @Test
    void testGetUserAvailableSubjects() {
        SubjectDAO subjectDAO = mock(SubjectDAO.class);
        when(subjectDAO.findAll()).thenReturn(new ArrayList<>());
        StudentController studentController = new StudentController(new StudentServiceImpl(mock(StudentDAO.class),
                mock(SubjectDAO.class), mock(ApplicationDAO.class), subjectDAO));
        User user = mock(User.class);
        when(user.getStudent()).thenReturn(new Student());
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user, "Credentials");

        assertEquals("student/available-subjects",
                studentController.getUserAvailableSubjects(authentication, new ConcurrentModel()));
        verify(subjectDAO).findAll();
        verify(user).getStudent();
    }

    /**
     * Method under test: {@link StudentController#getUserAvailableSubjects(Authentication, Model)}
     */
    @Test
    void testGetUserAvailableSubjects2() {
        SubjectDAO subjectDAO = mock(SubjectDAO.class);
        when(subjectDAO.findAll()).thenReturn(new ArrayList<>());
        StudentController studentController = new StudentController(new StudentServiceImpl(mock(StudentDAO.class),
                mock(SubjectDAO.class), mock(ApplicationDAO.class), subjectDAO));
        User user3 = new User();
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(new Professor());
        user3.setRole(Role.STUDENT);
        user3.setStudent(new Student());
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
        Subject subject = new Subject();
        subject.setDescription("The characteristics of someone or something");
        subject.setProfessor(new Professor());
        subject.setSubjectId(1);
        subject.setThesis(new Thesis());
        subject.setTitle("Dr");
        when(studentService.findById(anyInt())).thenReturn(new Student());
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
        StudentController studentController = new StudentController(new StudentServiceImpl());
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(new User(), "Credentials");

        assertEquals("student/student-details", studentController.changeDetails(authentication, new ConcurrentModel()));
    }


    /**
     * Method under test: {@link StudentController#saveDetails(Authentication, Student)}
     */
    @Test
    void testSaveDetails() {
        StudentDAO theStudentRepository = mock(StudentDAO.class);
        when(theStudentRepository.save(Mockito.<Student>any())).thenReturn(new Student());
        StudentController studentController = new StudentController(new StudentServiceImpl(theStudentRepository,
                mock(SubjectDAO.class), mock(ApplicationDAO.class), mock(SubjectDAO.class)));

        User user7 = mock(User.class);
        when(user7.getStudent()).thenReturn(new Student());
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user7, "Credentials");
        assertEquals("redirect:/student/dashboard", studentController.saveDetails(authentication, new Student()));
        verify(theStudentRepository).save(Mockito.<Student>any());
        verify(user7).getStudent();
    }
}

