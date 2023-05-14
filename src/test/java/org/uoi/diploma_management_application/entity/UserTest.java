package org.uoi.diploma_management_application.entity;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.mockito.Mockito.anyInt;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.security.core.GrantedAuthority;

public class UserTest {
    @Mock
    private Professor mockProfessor;

    @Mock
    private Student mockStudent;

    @Test
    public void testGetAuthorities() {
        User user = new User();
        user.setRole(Role.PROFESSOR);
        Collection<? extends GrantedAuthority> authorities = user.getAuthorities();
        assertEquals(1, authorities.size());
        assertEquals(Role.PROFESSOR.toString(), authorities.iterator().next().getAuthority());
    }

    @Test
    public void testGettersAndSetters() {
        User user = new User();
        user.setId(1);
        user.setUsername("john");
        user.setPassword("password");
        user.setRole(Role.STUDENT);
        user.setProfessor(mockProfessor);
        user.setStudent(mockStudent);

        assertEquals(1, user.getId());
        assertEquals("john", user.getUsername());
        assertEquals("password", user.getPassword());
        assertEquals(Role.STUDENT, user.getRole());
        assertEquals(mockProfessor, user.getProfessor());
        assertEquals(mockStudent, user.getStudent());
    }

    @Test
    public void testIsAccountNonExpired() {
        User user = new User();
        assertEquals(true, user.isAccountNonExpired());
    }

    @Test
    public void testIsAccountNonLocked() {
        User user = new User();
        assertEquals(true, user.isAccountNonLocked());
    }

    @Test
    public void testIsCredentialsNonExpired() {
        User user = new User();
        assertEquals(true, user.isCredentialsNonExpired());
    }

    @Test
    public void testIsEnabled() {
        User user = new User();
        assertEquals(true, user.isEnabled());
    }
}
