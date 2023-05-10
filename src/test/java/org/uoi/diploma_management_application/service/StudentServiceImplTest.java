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
        when(studentDAO.findAll()).thenReturn(studentList);
        List<Student> actualFindAllResult = studentServiceImpl.findAll();
        assertSame(studentList, actualFindAllResult);
        assertTrue(actualFindAllResult.isEmpty());
        verify(studentDAO).findAll();
    }

    /**
     * Method under test: {@link StudentServiceImpl#findAll()}
     */
    @Test
    void testFindAll2() {
        when(studentDAO.findAll()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> studentServiceImpl.findAll());
        verify(studentDAO).findAll();
    }

    /**
     * Method under test: {@link StudentServiceImpl#findById(int)}
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

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);
        when(studentDAO.findById(anyInt())).thenReturn(student4);
        assertSame(student4, studentServiceImpl.findById(1));
        verify(studentDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link StudentServiceImpl#findSubjectById(int)}
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
        assertSame(subject, studentServiceImpl.findSubjectById(1));
        verify(subjectDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link StudentServiceImpl#listStudentSubjects(int)}
     */
    @Test
    void testListStudentSubjects() {
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
        ArrayList<Application> applications = new ArrayList<>();
        student4.setApplications(applications);
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);
        when(studentDAO.findById(anyInt())).thenReturn(student4);
        List<Application> actualListStudentSubjectsResult = studentServiceImpl.listStudentSubjects(1);
        assertSame(applications, actualListStudentSubjectsResult);
        assertTrue(actualListStudentSubjectsResult.isEmpty());
        verify(studentDAO).findById(anyInt());
    }

    /**
     * Method under test: {@link StudentServiceImpl#save(Student)}
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

        Student student4 = new Student();
        student4.setApplications(new ArrayList<>());
        student4.setAverageGrade(10.0f);
        student4.setEmail("jane.doe@example.org");
        student4.setFirstName("Jane");
        student4.setLastName("Doe");
        student4.setRemainingCourses(1);
        student4.setStudentId(1);
        student4.setUser(user3);
        when(studentDAO.save(Mockito.<Student>any())).thenReturn(student4);

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
        ArrayList<Application> applications = new ArrayList<>();
        student5.setApplications(applications);
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

        Student theStudent = new Student();
        theStudent.setApplications(new ArrayList<>());
        theStudent.setAverageGrade(10.0f);
        theStudent.setEmail("jane.doe@example.org");
        theStudent.setFirstName("Jane");
        theStudent.setLastName("Doe");
        theStudent.setRemainingCourses(1);
        theStudent.setStudentId(1);
        theStudent.setUser(user6);
        studentServiceImpl.save(theStudent);
        verify(studentDAO).save(Mockito.<Student>any());
        assertEquals(applications, theStudent.getApplications());
        assertEquals(1, theStudent.getStudentId());
        assertEquals(1, theStudent.getRemainingCourses());
        assertEquals("Doe", theStudent.getLastName());
        assertEquals("Jane", theStudent.getFirstName());
        assertEquals("jane.doe@example.org", theStudent.getEmail());
        assertEquals(10.0f, theStudent.getAverageGrade());
        assertTrue(studentServiceImpl.findAll().isEmpty());
        assertTrue(studentServiceImpl.getAvailableSubjects().isEmpty());
    }

    /**
     * Method under test: {@link StudentServiceImpl#saveApplication(Application)}
     */
    @Test
    void testSaveApplication() {
        when(applicationDAO.save(Mockito.<Application>any())).thenReturn(new Application());
        studentServiceImpl.saveApplication(new Application());
        verify(applicationDAO).save(Mockito.<Application>any());
        assertTrue(studentServiceImpl.findAll().isEmpty());
        assertTrue(studentServiceImpl.getAvailableSubjects().isEmpty());
    }

    /**
     * Method under test: {@link StudentServiceImpl#saveApplication(Application)}
     */
    @Test
    void testSaveApplication2() {
        when(applicationDAO.save(Mockito.<Application>any())).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> studentServiceImpl.saveApplication(new Application()));
        verify(applicationDAO).save(Mockito.<Application>any());
    }

    /**
     * Method under test: {@link StudentServiceImpl#deleteById(int)}
     */
    @Test
    void testDeleteById() {
        doNothing().when(studentDAO).deleteById(Mockito.<Integer>any());
        studentServiceImpl.deleteById(1);
        verify(studentDAO).deleteById(Mockito.<Integer>any());
        assertTrue(studentServiceImpl.findAll().isEmpty());
        assertTrue(studentServiceImpl.getAvailableSubjects().isEmpty());
    }

    /**
     * Method under test: {@link StudentServiceImpl#deleteById(int)}
     */
    @Test
    void testDeleteById2() {
        doThrow(new RuntimeException("An error occurred")).when(studentDAO).deleteById(Mockito.<Integer>any());
        assertThrows(RuntimeException.class, () -> studentServiceImpl.deleteById(1));
        verify(studentDAO).deleteById(Mockito.<Integer>any());
    }

    /**
     * Method under test: {@link StudentServiceImpl#getAvailableSubjects()}
     */
    @Test
    void testGetAvailableSubjects() {
        ArrayList<Subject> subjectList = new ArrayList<>();
        when(subjectDAO.findAll()).thenReturn(subjectList);
        List<Subject> actualAvailableSubjects = studentServiceImpl.getAvailableSubjects();
        assertSame(subjectList, actualAvailableSubjects);
        assertTrue(actualAvailableSubjects.isEmpty());
        verify(subjectDAO).findAll();
    }

    /**
     * Method under test: {@link StudentServiceImpl#getAvailableSubjects()}
     */
    @Test
    void testGetAvailableSubjects2() {
        when(subjectDAO.findAll()).thenThrow(new RuntimeException("An error occurred"));
        assertThrows(RuntimeException.class, () -> studentServiceImpl.getAvailableSubjects());
        verify(subjectDAO).findAll();
    }

    /**
     * Method under test: {@link StudentServiceImpl#getThesis(Student)}
     */
    @Test
    void testGetThesis() {
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
        assertNull(studentServiceImpl.getThesis(student2));
    }

    /**
     * Method under test: {@link StudentServiceImpl#getThesis(Student)}
     */
    @Test
    void testGetThesis2() {
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

        Thesis thesis = new Thesis();
        thesis.setDescription("The characteristics of someone or something");
        thesis.setGrade(10.0f);
        thesis.setTId(1);
        thesis.setTitle("Dr");
        Student student2 = mock(Student.class);
        when(student2.getThesis()).thenReturn(thesis);
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
        assertSame(thesis, studentServiceImpl.getThesis(student2));
        verify(student2).getThesis();
        verify(student2).setApplications(Mockito.<List<Application>>any());
        verify(student2).setAverageGrade(anyFloat());
        verify(student2).setEmail(Mockito.<String>any());
        verify(student2).setFirstName(Mockito.<String>any());
        verify(student2).setLastName(Mockito.<String>any());
        verify(student2).setRemainingCourses(anyInt());
        verify(student2).setStudentId(anyInt());
        verify(student2).setUser(Mockito.<User>any());
    }
}

