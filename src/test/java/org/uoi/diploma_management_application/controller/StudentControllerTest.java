package org.uoi.diploma_management_application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
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
    void testGetUserHome() throws Exception {
        Student student = new Student();

        User user = mock(User.class);
        doNothing().when(user).setStudent(Mockito.<Student>any());
        when(user.getStudent()).thenReturn(student);

        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user, "Credentials");

        MockHttpServletRequestBuilder requestBuilder = post("/student/dashboard").
                principal(authentication);

        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(view().name("student/dashboard"));
    }

    /**
     * Method under test: {@link StudentController#getUserAvailableSubjects(Authentication, Model)}
     */
    @Test
    void testGetUserAvailableSubjects() throws Exception {
        Student student = new Student();

        User user = mock(User.class);
        doNothing().when(user).setStudent(Mockito.<Student>any());
        when(user.getStudent()).thenReturn(student);

        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user, "Credentials");

        MockHttpServletRequestBuilder requestBuilder = post("/student/available-subjects").
                principal(authentication);

        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("student/available-subjects"));

    }

    /**
     * Method under test: {@link StudentController#applySubject(int, int)}
     */
    @Test
    void testApplySubject() throws Exception {
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
    void testChangeDetails() throws Exception {
        User user = mock(User.class);
        doNothing().when(user).setStudent(Mockito.<Student>any());
        when(user.getStudent()).thenReturn(new Student());

        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user, "Credentials");

        MockHttpServletRequestBuilder requestBuilder = post("/student/change").principal(authentication);

        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isOk())
                .andExpect(view().name("student/student-details"));
    }


    /**
     * Method under test: {@link StudentController#saveDetails(Authentication, Student)}
     */
    @Test
    void testSaveDetails() throws Exception {
        Student student = new Student(1,"John", "Doe", "email",1,1);

        User user = mock(User.class);
        doNothing().when(user).setProfessor(Mockito.<Professor>any());
        when(user.getStudent()).thenReturn(student);

        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user, "Credentials");

        MockHttpServletRequestBuilder requestBuilder = post("/student/save_details").
                principal(authentication).
                flashAttr("student", student);

        MockMvcBuilders.standaloneSetup(studentController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/student/dashboard"));
    }
}

