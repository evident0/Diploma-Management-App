package org.uoi.diploma_management_application.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

class ProfessorTest {

    private Professor professor;

    @BeforeEach
    void setUp() {
        professor = new Professor("John", "Doe", "johndoe@example.com");
    }

    @Test
    void testConstructor() {
        assertEquals("John", professor.getFirstName());
        assertEquals("Doe", professor.getLastName());
        assertEquals("johndoe@example.com", professor.getEmail());
    }

    @Test
    void testCopyFields() {
        Professor otherProfessor = new Professor(2, "Jane", "Doe", "janedoe@example.com");
        professor.copyFields(otherProfessor);
        assertEquals(2, professor.getPId());
        assertEquals("Jane", professor.getFirstName());
        assertEquals("Doe", professor.getLastName());
        assertEquals("janedoe@example.com", professor.getEmail());
    }

    @Test
    void testSetUser() {
        User user = new User();
        user.setUsername("BOB");
        user.setPassword("iloveyou");
        professor.setUser(user);
        assertEquals(user, professor.getUser());
    }

    @Test
    void testToString() {
        String expected = "Professor [id=0, firstName=John, lastName=Doe, email=johndoe@example.com]";
        assertEquals(expected, professor.toString());
    }


}

