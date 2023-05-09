package org.uoi.diploma_management_application.entity;

import javax.persistence.*;


@Entity
public class Application {

    @EmbeddedId
    ApplicationKey id;

    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    Student student;

    @ManyToOne
    @MapsId("subjectId")
    @JoinColumn(name = "subject_id")
    Subject subject;

    public Application() {

    }

    public Application(int studentId, int subjectId, Student student, Subject subject) {
        ApplicationKey applicationKey = new ApplicationKey(subjectId, studentId);
        id = applicationKey;
        this.student = student;
        this.subject = subject;
    }

    public Student getStudent(){
        return student;
    }

    public String toString() {
        return "Application [id=" + id + ", student=" + student + ", subject=" + subject + "]\n";
    }
}
