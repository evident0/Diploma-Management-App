package myy803.springboot.sb_tutorial_3_thymeleaf.entity;

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
}
