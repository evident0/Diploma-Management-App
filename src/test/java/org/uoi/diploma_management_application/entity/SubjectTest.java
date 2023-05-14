package org.uoi.diploma_management_application.entity;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class SubjectTest {


    @Test
    public void testEmptyConstructor() {
        Subject subject = new Subject();
        assertNotNull(subject);
    }

    @Test
    public void testConstructorWithTitleAndDescription() {
        String title = "Test Title";
        String description = "Test Description";
        Subject subject = new Subject(title, description);
        assertNotNull(subject);
        assertEquals(title, subject.getTitle());
        assertEquals(description, subject.getDescription());
    }

    @Test
    public void testConstructorWithIdTitleAndDescription() {
        int subjectId = 1;
        String title = "Test Title";
        String description = "Test Description";
        Subject subject = new Subject(subjectId, title, description);
        assertNotNull(subject);
        assertEquals(subjectId, subject.getSubjectId());
        assertEquals(title, subject.getTitle());
        assertEquals(description, subject.getDescription());
    }

    @Test
    public void testGetAndSetSubjectId() {
        int subjectId = 1;
        Subject subject = new Subject();
        subject.setSubjectId(subjectId);
        assertEquals(subjectId, subject.getSubjectId());
    }

    @Test
    public void testGetAndSetProfessor() {
        Professor professor = new Professor();
        Subject subject = new Subject();
        subject.setProfessor(professor);
        assertEquals(professor, subject.getProfessor());
    }

    @Test
    public void testGetAndSetApplications() {
        List<Application> applications = new ArrayList<>();
        Subject subject = new Subject();
        subject.setApplications(applications);
        assertEquals(applications, subject.getApplications());
    }

}
