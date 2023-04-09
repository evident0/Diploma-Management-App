package myy803.springboot.sb_tutorial_3_thymeleaf.entity;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="subject")
public class Subject {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="subject_id")
    private int subjectId;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "p_id")
    private Professor professor;
    // define constructors

    @OneToMany(mappedBy = "subject", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Application> applications = new ArrayList<>();

    public Subject() {

    }

    public Subject(int subjectId, String title, String description) {
        this.subjectId = subjectId;
        this.title = title;
        this.description = description;
    }


    public Subject(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // define getter/setter

    public int getSubjectId() {
        return subjectId;
    }

    public void setSubjectId(int subjectId) {
        this.subjectId = subjectId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Subject [id=" + subjectId + ", title=" + title + ", description=" + description + "prof=" + professor + "]";
    }

}
