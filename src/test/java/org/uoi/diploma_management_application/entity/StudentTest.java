package org.uoi.diploma_management_application.entity;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
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


public class StudentTest {
    private Student student;

    @BeforeEach
    public void setup() {
        student = new Student("John", "Doe", "johndoe@example.com", 3, 8.5f);
    }

    @Test
    public void testCopyFields() {
        Student other = new Student();
        other.setStudentId(456);
        other.setFirstName("Bob");
        other.setLastName("Smith");
        other.setEmail("bobsmith@example.com");
        other.setRemainingCourses(4);
        other.setAverageGrade(7.5f);

        student.copyFields(other);

        Assertions.assertEquals(456, student.getStudentId());
        Assertions.assertEquals("Bob", student.getFirstName());
        Assertions.assertEquals("Smith", student.getLastName());
        Assertions.assertEquals("bobsmith@example.com", student.getEmail());
        Assertions.assertEquals(4, student.getRemainingCourses());
        Assertions.assertEquals(7.5f, student.getAverageGrade());
    }

    @Test
    public void testGetApplications() {
        List<Application> applications = new ArrayList<>();
        Application application1 = new Application(1,1,student,new Subject());
        applications.add(application1);
        student.setApplications(applications);

        Assertions.assertEquals(applications, student.getApplications());
    }

}
