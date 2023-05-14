package org.uoi.diploma_management_application.controller;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.uoi.diploma_management_application.dao.*;
import org.uoi.diploma_management_application.entity.*;
import org.uoi.diploma_management_application.service.ProfessorService;


@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-testing.properties")
@AutoConfigureMockMvc
public class StudentControllerIntegrationTest {

    @Autowired
    private ProfessorController studentController;

    @Autowired
    private ProfessorService professorService;

    @Autowired
    private ApplicationDAO applicationDAO;

    @Autowired
    private SubjectDAO subjectDAO;

    @Autowired
    private StudentDAO studentDAO;

    @Autowired
    private ThesisDAO thesisDAO;

    @Autowired
    private ProfessorDAO professorDAO;

    @Autowired
    private WebApplicationContext context;

    @Test
    void testApplySubject() throws Exception {

        Subject subject = new Subject(1,
                "Quantum Encryption",
                "The characteristics of someone or something"
        );

        Student student =  new Student(1,
                "BOB",
                "g",
                "m",
                1,
                1);
        subjectDAO.save(subject);
        studentDAO.save(student);

        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/student/apply-subject");
        MockHttpServletRequestBuilder paramResult = getResult.param("subjectId", String.valueOf(1));
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("thisStudentId", String.valueOf(1));
        MockMvcBuilders.webAppContextSetup(context)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(MockMvcResultMatchers.view().name("redirect:/student/dashboard"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/student/dashboard"));
    }

    @Test
    void testSaveDetails() throws Exception {
        Student student = new Student(1,"John", "Doe", "email",1,1);

        User user2 = new User();
        user2.setStudent(student);
        user2.setUsername("dddd");
        user2.setId(2);
        user2.setRole(Role.STUDENT);
        user2.setPassword("$2a$10$rlVrrxUN78snwziqoQc4A.Jrp30kgUdSGiJ8rUodo.EjjUxI39oNC");

        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user2, "Credentials");

        MockHttpServletRequestBuilder requestBuilder = post("/student/save_details").
                principal(authentication).
                flashAttr("student", student);

        MockMvcBuilders.webAppContextSetup(context)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/student/dashboard"));
    }

    @Test
    void testGetUserAvailableSubjects() throws Exception {

        Subject subject = new Subject(1,
                "Quantum Encryption",
                "The characteristics of someone or something"
        );

        Student student =  new Student(1,
                "BOB",
                "g",
                "m",
                1,
                1);

        Professor professor = new Professor(1,
                "zarras",
                "g",
                "mail"
                );
        subject.setProfessor(professor);


        professorDAO.save(professor);
        subjectDAO.save(subject);
        studentDAO.save(student);

        User user2 = new User();
        user2.setStudent(student);
        user2.setUsername("dddd");
        user2.setId(2);
        user2.setRole(Role.STUDENT);
        user2.setPassword("$2a$10$rlVrrxUN78snwziqoQc4A.Jrp30kgUdSGiJ8rUodo.EjjUxI39oNC");


        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user2, "Credentials");

        MockHttpServletRequestBuilder requestBuilder = post("/student/available-subjects").
                principal(authentication);

        MockMvcBuilders.webAppContextSetup(context)
                .build()
                .perform(requestBuilder)
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.view().name("student/available-subjects"));

    }

}
