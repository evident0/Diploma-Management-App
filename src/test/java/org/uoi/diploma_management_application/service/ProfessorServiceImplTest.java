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
import java.util.Arrays;
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
        professorList.add(new Professor(1,"BOB","SMITH","EMAIL"));

        when(professorDAO.findAll()).thenReturn(professorList);
        List<Professor> actualFindAllResult = professorServiceImpl.findAll();
        assertSame(professorList, actualFindAllResult);
        verify(professorDAO).findAll();
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findAll()}
     */
    @Test
    void testFindAllException() {
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
        when(professorDAO.findById(1)).thenReturn(professor);
        assertSame(professor, professorServiceImpl.findById(1));
        verify(professorDAO).findById(1);
    }

    @Test
    void testFindByIdRuntimeException() {

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());
        when(professorDAO.findById(1)).thenReturn(professor);
        assertThrows(RuntimeException.class, () -> professorServiceImpl.findById(42));
        verify(professorDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findStudentsBySubjectId(int)}
     */
    @Test
    void testFindStudentsBySubjectId() {

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Thesis thesis = new Thesis();
        thesis.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");

        List<Application> applications = new ArrayList<>();

        Subject subject = new Subject();

        Application application = new Application(1,1, student, subject);

        applications.add(application);

        subject.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        subject.setProfessor(professor);
        subject.setSubjectId(1);
        subject.setThesis(thesis);
        subject.setApplications(applications);
        subject.setTitle("Dr");

        when(subjectDAO.findById(1)).thenReturn(subject);
        assertEquals(Arrays.asList(student), professorServiceImpl.findStudentsBySubjectId(1));
        verify(subjectDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findSubjectById(int)}
     */
    @Test
    void testFindSubjectById() {

        Subject subject = new Subject();
        subject.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        subject.setProfessor(new Professor());
        subject.setSubjectId(1);
        subject.setThesis(new Thesis());
        subject.setTitle("Quantum Theory");
        when(subjectDAO.findById(1)).thenReturn(subject);
        assertSame(subject, professorServiceImpl.findSubjectById(1));
        verify(subjectDAO).findById(1);
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
        when(professorDAO.findByFirstName("Jane")).thenReturn(professor);
        assertSame(professor, professorServiceImpl.findByFirstName("Jane"));
        verify(professorDAO).findByFirstName("Jane");
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#save(Professor)}
     */
    @Test
    void testSave() {

        Professor theProfessor = new Professor();
        theProfessor.setEmail("jane.doe@example.org");
        theProfessor.setFirstName("Jane");
        theProfessor.setLastName("Doe");
        theProfessor.setPId(1);
        theProfessor.setUser(new User());
        professorServiceImpl.save(theProfessor);
        verify(professorDAO).save(theProfessor);

    }

    /**
     * Method under test: {@link ProfessorServiceImpl#saveThesis(Thesis)}
     */
    @Test
    void testSaveThesis() {
        Thesis thesis = new Thesis();
        thesis.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Quantum Theory");
        when(thesisDAO.save(Mockito.<Thesis>any())).thenReturn(thesis);

        Thesis theThesis = new Thesis();
        theThesis.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        theThesis.setGrade(10.0f);
        theThesis.setTId(1);
        theThesis.setTitle("Quantum Theory");
        professorServiceImpl.saveThesis(theThesis);
        verify(thesisDAO).save(Mockito.<Thesis>any());
        assertEquals("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", theThesis.getDescription());
        assertEquals("Quantum Theory", theThesis.getTitle());
        assertEquals(1, theThesis.getTId());
        assertEquals(10.0f, theThesis.getGrade());
        assertTrue(professorServiceImpl.findAll().isEmpty());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#saveThesis(Thesis)}
     */
    @Test
    void testSaveThesisException() {
        when(thesisDAO.save(Mockito.<Thesis>any())).thenThrow(new RuntimeException("An error occurred"));

        Thesis theThesis = new Thesis();
        theThesis.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        theThesis.setGrade(10.0f);
        theThesis.setTId(1);
        theThesis.setTitle("Quantum Theory");
        assertThrows(RuntimeException.class, () -> professorServiceImpl.saveThesis(theThesis));
        verify(thesisDAO).save(Mockito.<Thesis>any());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#saveSubject(Subject)}
     */
    @Test
    void testSaveSubject() {

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

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(new User());

        Thesis thesis2 = new Thesis();
        thesis2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        thesis2.setGrade(10.0f);
        thesis2.setTId(1);
        thesis2.setTitle("Quantum Theory");

        Subject theSubject = new Subject();

        Application application = new Application(1,1, student2, theSubject);

        applications.add(application);

        theSubject.setApplications(applications);

        theSubject.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        theSubject.setProfessor(professor4);
        theSubject.setSubjectId(1);
        theSubject.setThesis(thesis2);
        theSubject.setTitle("Quantum Theory");
        professorServiceImpl.saveSubject(theSubject);
        verify(subjectDAO).save(theSubject);

    }

    /**
     * Method under test: {@link ProfessorServiceImpl#deleteSubjectById(int)}
     */
    @Test
    void testDeleteSubjectById() {
        doNothing().when(subjectDAO).deleteById(Mockito.<Integer>any());
        professorServiceImpl.deleteSubjectById(1);
        verify(subjectDAO).deleteById(1);
        assertTrue(professorServiceImpl.findAll().isEmpty());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#deleteSubjectById(int)}
     */
    @Test
    void testDeleteSubjectByIdException() {
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
    void testDeleteApplicationByIdException() {
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
    void testDeleteByIdException() {
        doThrow(new RuntimeException("An error occurred")).when(professorDAO).deleteById(Mockito.<Integer>any());
        assertThrows(RuntimeException.class, () -> professorServiceImpl.deleteById(1));
        verify(professorDAO).deleteById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findThesisByPId(int)}
     */
    @Test
    void testFindThesisByPId() {
        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(new User());
        when(professorDAO.findById(1)).thenReturn(professor4);
        assertTrue(professorServiceImpl.findThesisByPId(1).isEmpty());
        verify(professorDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#findThesisById(int)}
     */
    @Test
    void testFindThesisById() {
        Thesis thesis = new Thesis();
        thesis.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Quantum Theory");
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


        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());

        Subject subject = new Subject();
        subject.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        subject.setProfessor(professor);
        subject.setSubjectId(1);
        subject.setThesis(null);
        subject.setTitle("Quantum Theory");

        Student student = new Student();
        student.setApplications(new ArrayList<>());
        student.setAverageGrade(10.0f);
        student.setEmail("jane.doe@example.org");
        student.setFirstName("Jane");
        student.setLastName("Doe");
        student.setRemainingCourses(1);
        student.setStudentId(1);
        student.setUser(new User());

        assertEquals(0, professorServiceImpl.assignThesis(student, subject));
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
        thesis.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Quantum Theory");

        Thesis thesis2 = new Thesis();
        thesis2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        thesis2.setGrade(10.0f);
        thesis2.setTId(1);
        thesis2.setTitle("Quantum Theory");
        professorServiceImpl.saveThesisGrade(thesis2, 10.0f);
        verify(thesisDAO).save(Mockito.<Thesis>any());
        assertEquals(10.0f, thesis2.getGrade());
    }

    /**
     * Method under test: {@link ProfessorServiceImpl#saveThesisGrade(Thesis, float)}
     */
    @Test
    void testSaveThesisGrade2() {
        Thesis thesis2 = mock(Thesis.class);

        thesis2.setDescription("Lorem ipsum dolor sit amet, consectetur adipiscing elit.");
        thesis2.setGrade(10.0f);
        thesis2.setTId(1);
        thesis2.setTitle("Quantum Theory");
        professorServiceImpl.saveThesisGrade(thesis2, 10.0f);
        verify(thesisDAO).save(Mockito.<Thesis>any());
        verify(thesis2).setDescription(Mockito.<String>any());
        verify(thesis2, atLeast(1)).setGrade(anyFloat());
        verify(thesis2).setTId(anyInt());
        verify(thesis2).setTitle(Mockito.<String>any());
    }
}

