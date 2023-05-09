package org.uoi.diploma_management_application.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="student")
public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="student_id")
    private int studentId;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="email")
    private String email;

    @Column(name="remaining_courses")
    private int remainingCourses;

    @Column(name="average_grade")
    private float averageGrade;

    public List<Application> getApplications() {
        return applications;
    }

    public void setApplications(List<Application> applications) {
        this.applications = applications;
    }

    @OneToMany(mappedBy = "student", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Application> applications = new ArrayList<>();

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id", referencedColumnName = "id")
    private User user;

    @OneToOne(mappedBy = "student", fetch = FetchType.LAZY)
    private Thesis thesis;

    public Student() {

    }

    public Student(int studentId, String firstName, String lastName, String email, int remainingCourses, float averageGrade) {
        this.studentId = studentId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.remainingCourses = remainingCourses;
        this.averageGrade = averageGrade;
    }

    public Student(String firstName, String lastName, String email, int remainingCourses, float averageGrade) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.remainingCourses = remainingCourses;
        this.averageGrade = averageGrade;
    }

    public void copyFields(Student student) {
        this.studentId = student.studentId;
        this.firstName = student.firstName;
        this.lastName = student.lastName;
        this.email = student.email;
        this.averageGrade = student.averageGrade;
        this.remainingCourses = student.remainingCourses;
    }


    public void setUser(User user) {
        this.user = user;
    }

    public int getStudentId() {
        return studentId;
    }


    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRemainingCourses(int remainingCourses) {
    	this.remainingCourses = remainingCourses;
    }
    public int getRemainingCourses() {
    	return remainingCourses;
    }
    public void setAverageGrade(float averageGrade) {
    	this.averageGrade = averageGrade;
    }
    public float getAverageGrade() {
    	return averageGrade;
    }

    public Thesis getThesis() {
    	return thesis;
    }

    @Override
    public String toString() {
        return "Student [id=" + studentId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
    }
}
