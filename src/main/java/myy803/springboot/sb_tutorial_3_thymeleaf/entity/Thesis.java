package myy803.springboot.sb_tutorial_3_thymeleaf.entity;

import javax.persistence.*;

@Entity
@Table(name="thesis")
public class Thesis {

    // define fields

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="t_id")
    private int t_id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "p_id")
    private Professor professor;
    // define constructors

    public Thesis() {

    }

    public Thesis(int t_id, String title, String description) {
        this.t_id = t_id;
        this.title = title;
        this.description = description;
    }


    public Thesis(String title, String description) {
        this.title = title;
        this.description = description;
    }

    // define getter/setter

    public int getTId() {
        return t_id;
    }

    public void setTId(int t_id) {
        this.t_id = t_id;
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
        return "Thesis [id=" + t_id + ", title=" + title + ", description=" + description + "]";
    }

}

