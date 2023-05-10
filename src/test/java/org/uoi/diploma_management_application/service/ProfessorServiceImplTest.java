package org.uoi.diploma_management_application.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.anyFloat;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.atLeast;
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
import org.uoi.diploma_management_application.dao.ProfessorDAO;
import org.uoi.diploma_management_application.dao.SubjectDAO;
import org.uoi.diploma_management_application.dao.ThesisDAO;
import org.uoi.diploma_management_application.entity.Application;
import org.uoi.diploma_management_application.entity.ApplicationKey;
import org.uoi.diploma_management_application.entity.Professor;
import org.uoi.diploma_management_application.entity.Role;
import org.uoi.diploma_management_application.entity.Student;
import org.uoi.diploma_management_application.entity.Subject;
import org.uoi.diploma_management_application.entity.Thesis;
import org.uoi.diploma_management_application.entity.User;

@ContextConfiguration(classes = {ProfessorServiceImpl.class})
@ExtendWith(SpringExtension.class)
class ProfessorServiceImplTest {
    @MockBean
    private ApplicationDAO applicationDAO;

    @MockBean
    private ProfessorDAO professorDAO;

    @Autowired
    private ProfessorServiceImpl professorServiceImpl;

    @MockBean
    private SubjectDAO subjectDAO;

    @MockBean
    private ThesisDAO thesisDAO;

    /**
     * Method under test: {@link ProfessorServiceImpl#findAll()}
     */
    @Test
    void testFindAll() {
        ArrayList<Professor> professorList = new ArrayList<>();
        when(professorDAO.findAll()).thenReturn(professorList);
        List<Professor> actualFindAllResult = professorServiceImpl.findAll();
        assertSame(professorList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(professorDAO).findAll();
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findAll()}
     */
    @Test
    void testFindAll2() {
        when(professorDAO.findAll()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> professorServiceImpl.findAll());
        verify(professorDAO).findAll();
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findById(int)}
     */
    @Test
    void testFindById() {
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
        when(professorDAO.findById(anyInt())).thenReturn(professor4);
        assertSame(professor4, professorServiceImpl.findById(1));
        verify(professorDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findStudentsBySubjectId(int)}
     */
    @Test
    void testFindStudentsBySubjectId() {
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
        when(subjectDAO.findById(anyInt())).thenReturn(subject);
        assertTrue(professorServiceImpl.findStudentsBySubjectId(1).isEmpty());
        verify(subjectDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findSubjectById(int)}
     */
    @Test
    void testFindSubjectById() {
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
        when(subjectDAO.findById(anyInt())).thenReturn(subject);
        assertSame(subject, professorServiceImpl.findSubjectById(1));
        verify(subjectDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findByFirstName(String)}
     */
    @Test
    void testFindByFirstName() {
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
        when(professorDAO.findByFirstName(Mockito.<String>any())).thenReturn(professor4);
        assertSame(professor4, professorServiceImpl.findByFirstName("Jane"));
        verify(professorDAO).findByFirstName(Mockito.<String>any());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#save(Professor)}
     */
    @Test
    void testSave() {
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
        when(professorDAO.save(Mockito.<Professor>any())).thenReturn(professor4);

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(new Professor());
        user4.setRole(Role.STUDENT);
        user4.setStudent(new Student());
        user4.setUsername("janedoe");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(user4);

        User user5 = new User();
        user5.setId(1);
        user5.setPassword("iloveyou");
        user5.setProfessor(new Professor());
        user5.setRole(Role.STUDENT);
        user5.setStudent(new Student());
        user5.setUsername("janedoe");

        Student student4 = new Student();
        ArrayList<Application> applications = new ArrayList<>();
        student4.setApplications(applications);
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
        user6.setProfessor(professor5);
        user6.setRole(Role.STUDENT);
        user6.setStudent(student4);
        user6.setUsername("janedoe");

        Professor theProfessor = new Professor();
        theProfessor.setEmail("jane.doe@example.org");
        theProfessor.setFirstName("Jane");
        theProfessor.setLastName("Doe");
        theProfessor.setPId(1);
        theProfessor.setUser(user6);
        professorServiceImpl.save(theProfessor);
        verify(professorDAO).save(Mockito.<Professor>any());
        assertEquals("jane.doe@example.org", theProfessor.getEmail());
        assertSame(user6, theProfessor.getUser());
        assertEquals(applications, theProfessor.getThesis());
        assertEquals("Jane", theProfessor.getFirstName());
        assertEquals(1, theProfessor.getPId());
        assertEquals(applications, theProfessor.getSubjects());
        assertEquals("Doe", theProfessor.getLastName());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#saveThesis(Thesis)}
     */
    @Test
    void testSaveThesis() {
        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");
        when(thesisDAO.save(Mockito.<Thesis>any())).thenReturn(thesis);

        Thesis theThesis = new Thesis();
        theThesis.setDescription("The characteristics of someone or something");
        theThesis.setGrade(10.0f);
        theThesis.setTId(1);
        theThesis.setTitle("Dr");
        professorServiceImpl.saveThesis(theThesis);
        verify(thesisDAO).save(Mockito.<Thesis>any());
        assertEquals("The characteristics of someone or something", theThesis.getDescription());
        assertEquals("Dr", theThesis.getTitle());
        assertEquals(1, theThesis.getTId());
        assertEquals(10.0f, theThesis.getGrade());
        assertTrue(professorServiceImpl.findAll().isEmpty());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#saveThesis(Thesis)}
     */
    @Test
    void testSaveThesis2() {
        when(thesisDAO.save(Mockito.<Thesis>any())).thenThrow(new RuntimeException("An error occurred"));

        Thesis theThesis = new Thesis();
        theThesis.setDescription("The characteristics of someone or something");
        theThesis.setGrade(10.0f);
        theThesis.setTId(1);
        theThesis.setTitle("Dr");
        assertThrows(RuntimeException.class, () -> professorServiceImpl.saveThesis(theThesis));
        verify(thesisDAO).save(Mockito.<Thesis>any());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#saveSubject(Subject)}
     */
    @Test
    void testSaveSubject() {
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
        when(subjectDAO.save(Mockito.<Subject>any())).thenReturn(subject);

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(new User());

        Student student2 = new Student();
        ArrayList<Application> applications = new ArrayList<>();
        student2.setApplications(applications);
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

        Thesis thesis2 = new Thesis();
        thesis2.setDescription("The characteristics of someone or something");
        thesis2.setGrade(10.0f);
        thesis2.setTId(1);
        thesis2.setTitle("Dr");

        Subject theSubject = new Subject();
        theSubject.setDescription("The characteristics of someone or something");
        theSubject.setProfessor(professor4);
        theSubject.setSubjectId(1);
        theSubject.setThesis(thesis2);
        theSubject.setTitle("Dr");
        professorServiceImpl.saveSubject(theSubject);
        verify(subjectDAO).save(Mockito.<Subject>any());
        assertEquals(applications, theSubject.getApplications());
        assertEquals("Dr", theSubject.getTitle());
        assertSame(thesis2, theSubject.getThesis());
        assertEquals(1, theSubject.getSubjectId());
        assertEquals("The characteristics of someone or something", theSubject.getDescription());
        assertSame(professor4, theSubject.getProfessor());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#deleteSubjectById(int)}
     */
    @Test
    void testDeleteSubjectById() {
        doNothing().when(subjectDAO).deleteById(Mockito.<Integer>any());
        professorServiceImpl.deleteSubjectById(1);
        verify(subjectDAO).deleteById(Mockito.<Integer>any());
        assertTrue(professorServiceImpl.findAll().isEmpty());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#deleteSubjectById(int)}
     */
    @Test
    void testDeleteSubjectById2() {
        doThrow(new RuntimeException("An error occurred")).when(subjectDAO).deleteById(Mockito.<Integer>any());
        assertThrows(RuntimeException.class, () -> professorServiceImpl.deleteSubjectById(1));
        verify(subjectDAO).deleteById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#deleteApplicationById(ApplicationKey)}
     */
    @Test
    void testDeleteApplicationById() {
        doNothing().when(applicationDAO).deleteById(Mockito.<ApplicationKey>any());
        professorServiceImpl.deleteApplicationById(new ApplicationKey());
        verify(applicationDAO).deleteById(Mockito.<ApplicationKey>any());
        assertTrue(professorServiceImpl.findAll().isEmpty());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#deleteApplicationById(ApplicationKey)}
     */
    @Test
    void testDeleteApplicationById2() {
        doThrow(new RuntimeException("An error occurred")).when(applicationDAO).deleteById(Mockito.<ApplicationKey>any());
        assertThrows(RuntimeException.class, () -> professorServiceImpl.deleteApplicationById(new ApplicationKey()));
        verify(applicationDAO).deleteById(Mockito.<ApplicationKey>any());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#deleteById(int)}
     */
    @Test
    void testDeleteById() {
        doNothing().when(professorDAO).deleteById(Mockito.<Integer>any());
        professorServiceImpl.deleteById(1);
        verify(professorDAO).deleteById(Mockito.<Integer>any());
        assertTrue(professorServiceImpl.findAll().isEmpty());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#deleteById(int)}
     */
    @Test
    void testDeleteById2() {
        doThrow(new RuntimeException("An error occurred")).when(professorDAO).deleteById(Mockito.<Integer>any());
        assertThrows(RuntimeException.class, () -> professorServiceImpl.deleteById(1));
        verify(professorDAO).deleteById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findThesisByPId(int)}
     */
    @Test
    void testFindThesisByPId() {
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
        when(professorDAO.findById(anyInt())).thenReturn(professor4);
        assertTrue(professorServiceImpl.findThesisByPId(1).isEmpty());
        verify(professorDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findThesisById(int)}
     */
    @Test
    void testFindThesisById() {
        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");
        when(thesisDAO.findById(anyInt())).thenReturn(thesis);
        assertSame(thesis, professorServiceImpl.findThesisById(1));
        verify(thesisDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findThesisById(int)}
     */
    @Test
    void testFindThesisById2() {
        when(thesisDAO.findById(anyInt())).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> professorServiceImpl.findThesisById(1));
        verify(thesisDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#assignThesis(Student, Subject)}
     */
    @Test
    void testAssignThesis() {
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

        Student student2 = new Student();
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(user3);

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(new User());

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(new User());

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(professor2);
        user4.setRole(Role.STUDENT);
        user4.setStudent(student3);
        user4.setUsername("janedoe");

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(user4);

        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");

        Subject subject = new Subject();
        subject.setDescription("The characteristics of someone or something");
        subject.setProfessor(professor3);
        subject.setSubjectId(1);
        subject.setThesis(thesis);
        subject.setTitle("Dr");
        assertEquals(-1, professorServiceImpl.assignThesis(student2, subject));
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#assignThesis(Student, Subject)}
     */
    @Test
    void testAssignThesis2() {
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
        Student student2 = mock(Student.class);
        doNothing().when(student2).setApplications(Mockito.<List<Application>>any());
        doNothing().when(student2).setAverageGrade(anyFloat());
        doNothing().when(student2).setEmail(Mockito.<String>any());
        doNothing().when(student2).setFirstName(Mockito.<String>any());
        doNothing().when(student2).setLastName(Mockito.<String>any());
        doNothing().when(student2).setRemainingCourses(anyInt());
        doNothing().when(student2).setStudentId(anyInt());
        doNothing().when(student2).setUser(Mockito.<User>any());
        student2.setApplications(new ArrayList<>());
        student2.setAverageGrade(10.0f);
        student2.setEmail("jane.doe@example.org");
        student2.setFirstName("Jane");
        student2.setLastName("Doe");
        student2.setRemainingCourses(1);
        student2.setStudentId(1);
        student2.setUser(user3);

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(new User());

        Student student3 = new Student();
        student3.setApplications(new ArrayList<>());
        student3.setAverageGrade(10.0f);
        student3.setEmail("jane.doe@example.org");
        student3.setFirstName("Jane");
        student3.setLastName("Doe");
        student3.setRemainingCourses(1);
        student3.setStudentId(1);
        student3.setUser(new User());

        User user4 = new User();
        user4.setId(1);
        user4.setPassword("iloveyou");
        user4.setProfessor(professor2);
        user4.setRole(Role.STUDENT);
        user4.setStudent(student3);
        user4.setUsername("janedoe");

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(user4);

        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");

        Subject subject = new Subject();
        subject.setDescription("The characteristics of someone or something");
        subject.setProfessor(professor3);
        subject.setSubjectId(1);
        subject.setThesis(thesis);
        subject.setTitle("Dr");
        assertEquals(-1, professorServiceImpl.assignThesis(student2, subject));
        verify(student2).setApplications(Mockito.<List<Application>>any());
        verify(student2).setAverageGrade(anyFloat());
        verify(student2).setEmail(Mockito.<String>any());
        verify(student2).setFirstName(Mockito.<String>any());
        verify(student2).setLastName(Mockito.<String>any());
        verify(student2).setRemainingCourses(anyInt());
        verify(student2).setStudentId(anyInt());
        verify(student2).setUser(Mockito.<User>any());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#calculateGrade(float, float, float)}
     */
    @Test
    void testCalculateGrade() {
        assertEquals(10.0f, professorServiceImpl.calculateGrade(10.0f, 10.0f, 10.0f));
        assertEquals(3.35f, professorServiceImpl.calculateGrade(0.5f, 10.0f, 10.0f));
        assertEquals(2.65f, professorServiceImpl.calculateGrade(-0.5f, 10.0f, 10.0f));
        assertEquals(Float.NaN, professorServiceImpl.calculateGrade(Float.NaN, 10.0f, 10.0f));
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#saveThesisGrade(Thesis, float)}
     */
    @Test
    void testSaveThesisGrade() {
        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");
        when(thesisDAO.save(Mockito.<Thesis>any())).thenReturn(thesis);

        Thesis thesis2 = new Thesis();
        thesis2.setDescription("The characteristics of someone or something");
        thesis2.setGrade(10.0f);
        thesis2.setTId(1);
        thesis2.setTitle("Dr");
        professorServiceImpl.saveThesisGrade(thesis2, 10.0f);
        verify(thesisDAO).save(Mockito.<Thesis>any());
        assertEquals(10.0f, thesis2.getGrade());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#saveThesisGrade(Thesis, float)}
     */
    @Test
    void testSaveThesisGrade2() {
        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");
        when(thesisDAO.save(Mockito.<Thesis>any())).thenReturn(thesis);
        Thesis thesis2 = mock(Thesis.class);
        doNothing().when(thesis2).setDescription(Mockito.<String>any());
        doNothing().when(thesis2).setGrade(anyFloat());
        doNothing().when(thesis2).setTId(anyInt());
        doNothing().when(thesis2).setTitle(Mockito.<String>any());
        thesis2.setDescription("The characteristics of someone or something");
        thesis2.setGrade(10.0f);
        thesis2.setTId(1);
        thesis2.setTitle("Dr");
        professorServiceImpl.saveThesisGrade(thesis2, 10.0f);
        verify(thesisDAO).save(Mockito.<Thesis>any());
        verify(thesis2).setDescription(Mockito.<String>any());
        verify(thesis2, atLeast(1)).setGrade(anyFloat());
        verify(thesis2).setTId(anyInt());
        verify(thesis2).setTitle(Mockito.<String>any());
    }
}

