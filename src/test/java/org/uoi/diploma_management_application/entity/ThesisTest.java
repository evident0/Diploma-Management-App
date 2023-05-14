package org.uoi.diploma_management_application.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class ThesisTest {
    @Test
    public void testSubjectConstructor() {
        Subject s = new Subject(1, "Math", "A subject about numbers");
        assertEquals(1, s.getSubjectId());
        assertEquals("Math", s.getTitle());
        assertEquals("A subject about numbers", s.getDescription());
    }

    @Test
    public void testSetAndGetTitle() {
        Subject s = new Subject();
        s.setTitle("English");
        assertEquals("English", s.getTitle());
    }

    @Test
    public void testSetAndGetDescription() {
        Subject s = new Subject();
        s.setDescription("A subject about literature");
        assertEquals("A subject about literature", s.getDescription());
    }

    @Test
    public void testSetAndGetProfessor() {
        Subject s = new Subject();
        Professor p = new Professor();
        s.setProfessor(p);
        assertEquals(p, s.getProfessor());
    }

    @Test
    public void testSetAndGetApplications() {
        Subject s = new Subject();
        Application a = new Application();
        s.setApplications(Arrays.asList(a));
        assertEquals(Arrays.asList(a), s.getApplications());
    }

    @Test
    public void testSetAndGetThesis() {
        Subject s = new Subject();
        Thesis t = new Thesis();
        s.setThesis(t);
        assertEquals(t, s.getThesis());
    }

}
