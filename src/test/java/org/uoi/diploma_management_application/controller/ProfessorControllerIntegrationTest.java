package org.uoi.diploma_management_application.controller;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.jdbc.JdbcTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.uoi.diploma_management_application.dao.*;
import org.uoi.diploma_management_application.entity.*;
import org.uoi.diploma_management_application.service.ProfessorService;

import java.util.ArrayList;


@SpringBootTest
@TestPropertySource(
        locations = "classpath:application-testing.properties")
@AutoConfigureMockMvc
//@DirtiesContext(classMode = DirtiesContext.ClassMode.BEFORE_EACH_TEST_METHOD)
public class ProfessorControllerIntegrationTest {

    @Autowired
    private ProfessorController professorController;

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
    private UserDAO userDAO;

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private WebApplicationContext context;
/*
    @BeforeEach
    void clearDatabase() {
        subjectDAO.deleteAll();
        applicationDAO.deleteAll();
        studentDAO.deleteAll();
        thesisDAO.deleteAll();
        professorDAO.deleteAll();
        userDAO.deleteAll();

        //JdbcTestUtils.deleteFromTables(jdbcTemplate, "student", "application", "subject", "professor", "users", "thesis");
    }
*/
    @Test
    //@Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void testSaveDetails() throws Exception {

        Professor professor = new Professor(1,"John", "Doe", "email");

        User user2 = new User();
        user2.setProfessor(professor);
        user2.setUsername("dddd");
        user2.setId(2);
        user2.setRole(Role.PROFESSOR);
        user2.setPassword("$2a$10$rlVrrxUN78snwziqoQc4A.Jrp30kgUdSGiJ8rUodo.EjjUxI39oNC");

        //professor.setUser(user2);

        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user2, "Credentials");

        MockHttpServletRequestBuilder requestBuilder = post("/professor/save_details").
                principal(authentication).
                flashAttr("professor", professor);

        MockMvcBuilders.webAppContextSetup(context)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.redirectedUrl("/professor/dashboard"));
    }
    @Test
    //@Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void testPickStudent() throws Exception {

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
        applicationDAO.save(new Application(1,1, student, subject));

        MockHttpServletRequestBuilder paramResult = post("/professor/pick-student")
                .param("pickMethod", "random");
        MockHttpServletRequestBuilder requestBuilder = paramResult.param("subjectId", String.valueOf(1));
        MockMvcBuilders.webAppContextSetup(context)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(view().name("redirect:/professor/dashboard"))
                .andExpect(redirectedUrl("/professor/dashboard"));
    }

    @Test
    //@Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void testSaveGrade() throws Exception {

        Thesis thesis = new Thesis();
        thesis.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        //thesis.setGrade(10.0f);
        thesis.setTId(2);
        thesis.setTitle("Dr");

        thesisDAO.save(thesis);

        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/professor/save-grade");
        MockHttpServletRequestBuilder paramResult = getResult.param("gradeI", String.valueOf(10.0f));
        MockHttpServletRequestBuilder paramResult2 = paramResult.param("gradeP", String.valueOf(10.0f));
        MockHttpServletRequestBuilder paramResult3 = paramResult2.param("gradeR", String.valueOf(10.0f));
        MockHttpServletRequestBuilder requestBuilder = paramResult3.param("thesisId", String.valueOf(2));
        MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(view().name("redirect:/professor/dashboard"))
                .andExpect(redirectedUrl("/professor/dashboard"));
    }

    @Test
    //@Sql(scripts = "classpath:data.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
    void testDeleteSubject() throws Exception {



        Subject subject = new Subject(1,
                "Quantum Encryption",
                "The characteristics of someone or something"
        );
        subjectDAO.save(subject);

        MockHttpServletRequestBuilder getResult = MockMvcRequestBuilders.get("/professor/delete-subject");
        MockHttpServletRequestBuilder requestBuilder = getResult.param("subjectId", String.valueOf(1));
        MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(requestBuilder)
                .andExpect(status().isFound())
                .andExpect(MockMvcResultMatchers.model().size(0))
                .andExpect(view().name("redirect:/professor/dashboard"))
                .andExpect(redirectedUrl("/professor/dashboard"));
    }


}
