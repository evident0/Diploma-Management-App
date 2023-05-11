package org.uoi.diploma_management_application.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.authentication;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.lang.annotation.Annotation;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.stubbing.Answer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
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
    void testGetProfessorHome() {
        ProfessorDAO theProfessorRepository = mock(ProfessorDAO.class);
        when(theProfessorRepository.findById(anyInt())).thenReturn(new Professor());
        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl(theProfessorRepository,
                mock(SubjectDAO.class), mock(ThesisDAO.class), mock(ApplicationDAO.class)));

        User user = mock(User.class);
        doNothing().when(user).setProfessor(Mockito.<Professor>any());
        when(user.getProfessor()).thenReturn(new Professor());
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(user, "Credentials");

        assertEquals("professor/dashboard", professorController.getProfessorHome(authentication, new ConcurrentModel()));
        verify(theProfessorRepository).findById(anyInt());
        verify(user, atLeast(1)).getProfessor();
        verify(user).setProfessor(Mockito.<Professor>any());
    }

    /**
     * Method under test: {@link ProfessorController#saveSubject(Authentication, Subject)}
     */
    @Test
    void testSaveSubject() {
        SubjectDAO theSubjectRepository = mock(SubjectDAO.class);
        when(theSubjectRepository.save(Mockito.<Subject>any())).thenReturn(new Subject());
        ProfessorController professorController = new ProfessorController(new ProfessorServiceImpl(
                mock(ProfessorDAO.class), theSubjectRepository, mock(ThesisDAO.class), mock(ApplicationDAO.class)));
        TestingAuthenticationToken authentication = new TestingAuthenticationToken(new User(), "Credentials");

        Subject theSubject = new Subject();
        assertEquals("redirect:/professor/dashboard", professorController.saveSubject(authentication, theSubject));
        verify(theSubjectRepository).save(Mockito.<Subject>any());
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

    public interface WithSecurityContextFactory<A extends Annotation> {

        SecurityContext createSecurityContext(A annotation);
    }
/*
    public class ControllerTestablekserogwti extends ProfessorController {

        @Autowired
        public ControllerTestablekserogwti(ProfessorService theProfessorService) {
            professorService = theProfessorService;
        }
        @Override
        public Professor getProfessorByAuthentication(Authentication authentication) {
            return new Professor();
        }
    }


    @Test
    @WithMockUser(roles="PROFESSOR")
    void testSaveDetails() throws Exception {

        Professor professor = new Professor("Bob", "Mastoras", "bob@mail");
        // Create a mock Professor object
        Professor mockProfessor = new Professor();
        mockProfessor.setFirstName("John Doe");

        // Create a User object with a non-null Professor field
        User user = new User();
        user.setProfessor(mockProfessor);

        MultiValueMap<String, String> multiValueMap = new LinkedMultiValueMap<>();
        multiValueMap.add("pId", Integer.toString(professor.getPId()));
        multiValueMap.add("firstName", professor.getFirstName());
        multiValueMap.add("lastName", professor.getLastName());
        multiValueMap.add("email", professor.getEmail());

        when(professorController.getProfessorByAuthentication(any())).thenReturn(professor);

        //when((User) authentication.getPrincipal()).thenReturn(new User());
        mockMvc.perform(
                        post("/professor/save_details").with(authentication(new UsernamePasswordAuthenticationToken(user, null)))
                                .params(multiValueMap))
                .andExpect(status().isFound())
                .andExpect(view().name("redirect:/professor/dashboard"));

        MockHttpServletRequestBuilder paramResult = MockMvcRequestBuilders.post("/professor/save_details")
                .params(multiValueMap);
        System.out.println("sdffffffffffffffffffffffffffffffffffffffffffffffffffffffffffff"+paramResult);
        MockMvcBuilders.standaloneSetup(professorController)
                .build()
                .perform(paramResult)
                .andExpect(MockMvcResultMatchers.status().isFound())
                .andExpect(MockMvcResultMatchers.view().name("redirect:/professor/dashboard"))
                .andExpect(MockMvcResultMatchers.redirectedUrl("/professor/dashboard"));

    }

    @Test
    @WithMockUser(roles="PROFESSOR")
    @WithUserDetails("janedoe")
    public void test2SaveDetails() throws Exception {
        // Create a mock Professor object
        Professor mockProfessor = new Professor();
        mockProfessor.setFirstName("John Doe");

        // Create a User object with a non-null Professor field
        User user = new User();
        user.setProfessor(mockProfessor);

        // Override the behavior of getProfessorByAuthentication() to return the User's Professor
        when(professorController.getProfessorByAuthentication(any(Authentication.class))).thenAnswer((Answer<Professor>) invocation -> {
            Authentication auth = invocation.getArgument(0);
            User u = (User) auth.getPrincipal();
            return u.getProfessor();
        });

        // Perform the request with the User object as the Authentication principal
        mockMvc.perform(post("/professor/save_details")
                        .with(authentication(new UsernamePasswordAuthenticationToken(user, null)))
                        .flashAttr("professor", mockProfessor))
                .andExpect(status().isFound())
                .andExpect(redirectedUrl("/professor/dashboard"));
    }
    */

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
                .andExpect(redirectedUrl("/professor/dashboard"));
    }

    /**
     * Method under test: {@link ProfessorController#pickByThresholds(float, int, int)}
     */
    @Test
    void testPickByThresholds() throws Exception {

        when(professorService.assignThesis(Mockito.<Student>any(), Mockito.<Subject>any())).thenReturn(1);
        when(professorService.findStudentsBySubjectId(anyInt())).thenReturn(new ArrayList<>());
        when(professorService.findSubjectById(anyInt())).thenReturn(new Subject());
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
                .andExpect(redirectedUrl("/professor/dashboard"));
    }

    /**
     * Method under test: {@link ProfessorController#pickStudent(String, int)}
     */
    @Test
    void testPickStudent() throws Exception {
        Subject subject = new Subject();
        subject.setDescription("The characteristics of someone or something");
        subject.setProfessor(new Professor());
        subject.setSubjectId(1);
        subject.setThesis(new Thesis());
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
                .andExpect(redirectedUrl("/professor/dashboard"));
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
                .andExpect(redirectedUrl("/professor/dashboard"));
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

