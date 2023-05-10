package org.uoi.diploma_management_application.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProfessorTest {
    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Professor#Professor()}
     *   <li>{@link Professor#setEmail(String)}
     *   <li>{@link Professor#setFirstName(String)}
     *   <li>{@link Professor#setLastName(String)}
     *   <li>{@link Professor#setPId(int)}
     *   <li>{@link Professor#setUser(User)}
     *   <li>{@link Professor#toString()}
     *   <li>{@link Professor#getEmail()}
     *   <li>{@link Professor#getUser()}
     *   <li>{@link Professor#getFirstName()}
     *   <li>{@link Professor#getLastName()}
     *   <li>{@link Professor#getPId()}
     *   <li>{@link Professor#getSubjects()}
     *   <li>{@link Professor#getThesis()}
     * </ul>
     */
    @Test
    void testConstructor() {
        Professor actualProfessor = new Professor();
        actualProfessor.setEmail("jane.doe@example.org");
        actualProfessor.setFirstName("Jane");
        actualProfessor.setLastName("Doe");
        actualProfessor.setPId(1);
        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());
        Student student = new Student();
        ArrayList<Application> applications = new ArrayList<>();
        student.setApplications(applications);
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
        ArrayList<Application> applications2 = new ArrayList<>();
        student2.setApplications(applications2);
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
        ArrayList<Application> applications3 = new ArrayList<>();
        student3.setApplications(applications3);
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
        actualProfessor.setUser(user3);
        String actualToStringResult = actualProfessor.toString();
        assertEquals("jane.doe@example.org", actualProfessor.getEmail());
        User user4 = actualProfessor.getUser();
        Professor professor4 = user4.getProfessor();
        assertEquals("jane.doe@example.org", professor4.getEmail());
        assertEquals("Jane", actualProfessor.getFirstName());
        assertEquals("Jane", professor4.getFirstName());
        assertEquals("Doe", actualProfessor.getLastName());
        assertEquals("Doe", professor4.getLastName());
        assertEquals(1, actualProfessor.getPId());
        assertEquals(1, professor4.getPId());
        List<Subject> subjects = actualProfessor.getSubjects();
        assertEquals(applications, subjects);
        assertEquals(applications3, subjects);
        assertEquals(applications2, subjects);
        List<Thesis> thesis = actualProfessor.getThesis();
        assertEquals(thesis, subjects);
        List<Subject> subjects2 = professor4.getSubjects();
        assertEquals(applications, subjects2);
        assertEquals(applications2, subjects2);
        assertEquals(subjects, subjects2);
        assertEquals(thesis, subjects2);
        List<Application> applications4 = user4.getStudent().getApplications();
        assertEquals(applications4, subjects2);
        List<Thesis> thesis2 = professor4.getThesis();
        assertEquals(thesis2, subjects2);
        assertEquals(applications, thesis);
        assertEquals(applications3, thesis);
        assertEquals(applications2, thesis);
        assertEquals(applications, thesis2);
        assertEquals(applications2, thesis2);
        assertEquals(subjects, thesis2);
        assertEquals(thesis, thesis2);
        assertEquals(applications4, thesis2);
        assertSame(user3, user4);
        assertSame(user, professor4.getUser());
        assertEquals("Professor [id=1, firstName=Jane, lastName=Doe, email=jane.doe@example.org]", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Professor#Professor(int, String, String, String)}
     *   <li>{@link Professor#setEmail(String)}
     *   <li>{@link Professor#setFirstName(String)}
     *   <li>{@link Professor#setLastName(String)}
     *   <li>{@link Professor#setPId(int)}
     *   <li>{@link Professor#Professor()}
     *   <li>{@link Professor#setUser(User)}
     *   <li>{@link Professor#toString()}
     *   <li>{@link Professor#getEmail()}
     *   <li>{@link Professor#getUser()}
     *   <li>{@link Professor#getFirstName()}
     *   <li>{@link Professor#getLastName()}
     *   <li>{@link Professor#getPId()}
     *   <li>{@link Professor#getSubjects()}
     *   <li>{@link Professor#getThesis()}
     * </ul>
     */
    @Test
    void testConstructor2() {
        Professor actualProfessor = new Professor(1, "Jane", "Doe", "jane.doe@example.org");
        actualProfessor.setEmail("jane.doe@example.org");
        actualProfessor.setFirstName("Jane");
        actualProfessor.setLastName("Doe");
        actualProfessor.setPId(1);
        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());
        Student student = new Student();
        ArrayList<Application> applications = new ArrayList<>();
        student.setApplications(applications);
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
        ArrayList<Application> applications2 = new ArrayList<>();
        student2.setApplications(applications2);
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
        ArrayList<Application> applications3 = new ArrayList<>();
        student3.setApplications(applications3);
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
        actualProfessor.setUser(user3);
        String actualToStringResult = actualProfessor.toString();
        assertEquals("jane.doe@example.org", actualProfessor.getEmail());
        User user4 = actualProfessor.getUser();
        Professor professor4 = user4.getProfessor();
        assertEquals("jane.doe@example.org", professor4.getEmail());
        assertEquals("Jane", actualProfessor.getFirstName());
        assertEquals("Jane", professor4.getFirstName());
        assertEquals("Doe", actualProfessor.getLastName());
        assertEquals("Doe", professor4.getLastName());
        assertEquals(1, actualProfessor.getPId());
        assertEquals(1, professor4.getPId());
        List<Subject> subjects = actualProfessor.getSubjects();
        assertEquals(applications, subjects);
        assertEquals(applications3, subjects);
        assertEquals(applications2, subjects);
        List<Thesis> thesis = actualProfessor.getThesis();
        assertEquals(thesis, subjects);
        List<Subject> subjects2 = professor4.getSubjects();
        assertEquals(applications, subjects2);
        assertEquals(applications2, subjects2);
        assertEquals(subjects, subjects2);
        assertEquals(thesis, subjects2);
        List<Application> applications4 = user4.getStudent().getApplications();
        assertEquals(applications4, subjects2);
        List<Thesis> thesis2 = professor4.getThesis();
        assertEquals(thesis2, subjects2);
        assertEquals(applications, thesis);
        assertEquals(applications3, thesis);
        assertEquals(applications2, thesis);
        assertEquals(applications, thesis2);
        assertEquals(applications2, thesis2);
        assertEquals(subjects, thesis2);
        assertEquals(thesis, thesis2);
        assertEquals(applications4, thesis2);
        assertSame(user3, user4);
        assertSame(user, professor4.getUser());
        assertEquals("Professor [id=1, firstName=Jane, lastName=Doe, email=jane.doe@example.org]", actualToStringResult);
    }

    /**
     * Methods under test:
     *
     * <ul>
     *   <li>{@link Professor#Professor(String, String, String)}
     *   <li>{@link Professor#setEmail(String)}
     *   <li>{@link Professor#setFirstName(String)}
     *   <li>{@link Professor#setLastName(String)}
     *   <li>{@link Professor#setPId(int)}
     *   <li>{@link Professor#Professor()}
     *   <li>{@link Professor#setUser(User)}
     *   <li>{@link Professor#toString()}
     *   <li>{@link Professor#getEmail()}
     *   <li>{@link Professor#getUser()}
     *   <li>{@link Professor#getFirstName()}
     *   <li>{@link Professor#getLastName()}
     *   <li>{@link Professor#getPId()}
     *   <li>{@link Professor#getSubjects()}
     *   <li>{@link Professor#getThesis()}
     * </ul>
     */
    @Test
    void testConstructor3() {
        Professor actualProfessor = new Professor("Jane", "Doe", "jane.doe@example.org");
        actualProfessor.setEmail("jane.doe@example.org");
        actualProfessor.setFirstName("Jane");
        actualProfessor.setLastName("Doe");
        actualProfessor.setPId(1);
        Professor professor = new Professor();
        professor.setEmail("jane.doe@example.org");
        professor.setFirstName("Jane");
        professor.setLastName("Doe");
        professor.setPId(1);
        professor.setUser(new User());
        Student student = new Student();
        ArrayList<Application> applications = new ArrayList<>();
        student.setApplications(applications);
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
        ArrayList<Application> applications2 = new ArrayList<>();
        student2.setApplications(applications2);
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
        ArrayList<Application> applications3 = new ArrayList<>();
        student3.setApplications(applications3);
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
        actualProfessor.setUser(user3);
        String actualToStringResult = actualProfessor.toString();
        assertEquals("jane.doe@example.org", actualProfessor.getEmail());
        User user4 = actualProfessor.getUser();
        Professor professor4 = user4.getProfessor();
        assertEquals("jane.doe@example.org", professor4.getEmail());
        assertEquals("Jane", actualProfessor.getFirstName());
        assertEquals("Jane", professor4.getFirstName());
        assertEquals("Doe", actualProfessor.getLastName());
        assertEquals("Doe", professor4.getLastName());
        assertEquals(1, actualProfessor.getPId());
        assertEquals(1, professor4.getPId());
        List<Subject> subjects = actualProfessor.getSubjects();
        assertEquals(applications, subjects);
        assertEquals(applications3, subjects);
        assertEquals(applications2, subjects);
        List<Thesis> thesis = actualProfessor.getThesis();
        assertEquals(thesis, subjects);
        List<Subject> subjects2 = professor4.getSubjects();
        assertEquals(applications, subjects2);
        assertEquals(applications2, subjects2);
        assertEquals(subjects, subjects2);
        assertEquals(thesis, subjects2);
        List<Application> applications4 = user4.getStudent().getApplications();
        assertEquals(applications4, subjects2);
        List<Thesis> thesis2 = professor4.getThesis();
        assertEquals(thesis2, subjects2);
        assertEquals(applications, thesis);
        assertEquals(applications3, thesis);
        assertEquals(applications2, thesis);
        assertEquals(applications, thesis2);
        assertEquals(applications2, thesis2);
        assertEquals(subjects, thesis2);
        assertEquals(thesis, thesis2);
        assertEquals(applications4, thesis2);
        assertSame(user3, user4);
        assertSame(user, professor4.getUser());
        assertEquals("Professor [id=1, firstName=Jane, lastName=Doe, email=jane.doe@example.org]", actualToStringResult);
    }

    /**
     * Method under test: {@link Professor#copyFields(Professor)}
     */
    @Test
    void testCopyFields() {
        // TODO: Complete this test.
        //   Diffblue AI was unable to find a test

        Professor professor = new Professor();

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(new User());

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
        user.setProfessor(professor2);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(user);

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(new User());

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
        user2.setProfessor(professor4);
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
        user3.setProfessor(professor3);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(user3);
        professor.copyFields(professor5);
    }

    /**
     * Method under test: {@link Professor#copyFields(Professor)}
     */
    @Test
    void testCopyFields2() {
        Professor professor = new Professor();

        Professor professor2 = new Professor();
        professor2.setEmail("jane.doe@example.org");
        professor2.setFirstName("Jane");
        professor2.setLastName("Doe");
        professor2.setPId(1);
        professor2.setUser(new User());

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
        user.setProfessor(professor2);
        user.setRole(Role.STUDENT);
        user.setStudent(student);
        user.setUsername("janedoe");

        Professor professor3 = new Professor();
        professor3.setEmail("jane.doe@example.org");
        professor3.setFirstName("Jane");
        professor3.setLastName("Doe");
        professor3.setPId(1);
        professor3.setUser(user);

        Professor professor4 = new Professor();
        professor4.setEmail("jane.doe@example.org");
        professor4.setFirstName("Jane");
        professor4.setLastName("Doe");
        professor4.setPId(1);
        professor4.setUser(new User());

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
        user2.setProfessor(professor4);
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
        User user3 = mock(User.class);
        doNothing().when(user3).setId(anyInt());
        doNothing().when(user3).setPassword(Mockito.<String>any());
        doNothing().when(user3).setProfessor(Mockito.<Professor>any());
        doNothing().when(user3).setRole(Mockito.<Role>any());
        doNothing().when(user3).setStudent(Mockito.<Student>any());
        doNothing().when(user3).setUsername(Mockito.<String>any());
        user3.setId(1);
        user3.setPassword("iloveyou");
        user3.setProfessor(professor3);
        user3.setRole(Role.STUDENT);
        user3.setStudent(student3);
        user3.setUsername("janedoe");

        Professor professor5 = new Professor();
        professor5.setEmail("jane.doe@example.org");
        professor5.setFirstName("Jane");
        professor5.setLastName("Doe");
        professor5.setPId(1);
        professor5.setUser(user3);
        professor.copyFields(professor5);
        verify(user3).setId(anyInt());
        verify(user3).setPassword(Mockito.<String>any());
        verify(user3).setProfessor(Mockito.<Professor>any());
        verify(user3).setRole(Mockito.<Role>any());
        verify(user3).setStudent(Mockito.<Student>any());
        verify(user3).setUsername(Mockito.<String>any());
        assertEquals("jane.doe@example.org", professor.getEmail());
        assertEquals(1, professor.getPId());
        assertEquals("Doe", professor.getLastName());
        assertEquals("Jane", professor.getFirstName());
    }
}

