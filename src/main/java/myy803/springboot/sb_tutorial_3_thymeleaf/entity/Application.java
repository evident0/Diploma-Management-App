package myy803.springboot.sb_tutorial_3_thymeleaf.entity;

import myy803.springboot.sb_tutorial_3_thymeleaf.dao.StudentDAO;
import myy803.springboot.sb_tutorial_3_thymeleaf.dao.SubjectDAO;

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

    public Application(int studentId, int subjectId, Student student, Subject subject) {
        ApplicationKey applicationKey = new ApplicationKey();
        applicationKey.studentId = studentId;
        applicationKey.subjectId = subjectId;

        id = applicationKey;

        this.student = student;
        this.subject = subject;
    }

    public Application() {

    }

    public Student getStudent(){
        return student;
    }

    public String toString() {
        return "Application [id=" + id + ", student=" + student + ", subject=" + subject + "]\n";
    }
}
