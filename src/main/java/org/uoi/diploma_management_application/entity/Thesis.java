package org.uoi.diploma_management_application.entity;

import javax.persistence.*;

@Entity
@Table(name="thesis")
public class Thesis {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="t_id")
    private int t_id;

    @Column(name="title")
    private String title;

    @Column(name="description")
    private String description;

    @Column(name="grade")
    private float grade;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "p_id")
    private Professor professor;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_id", referencedColumnName = "subject_id")
    private Subject subject;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "student_id", referencedColumnName = "student_id")
    private Student student;

    public Thesis() {

    }

    public Thesis(int t_id, String title, String description) {
        this.t_id = t_id;
        this.title = title;
        this.description = description;
        this.grade = 0;
    }

    public Thesis(Subject subject, Student student) {
        this.title = subject.getTitle();
        this.description = subject.getDescription();
        this.professor = subject.getProfessor();
        this.subject = subject;
        this.student = student;
        this.grade = 0;
    }


    public Thesis(String title, String description) {
        this.title = title;
        this.description = description;
    }


    public int getTId() {
        return t_id;
    }

    public void setTId(int t_id) {
        this.t_id = t_id;
    }

    public Student getStudent(){
        return student;
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

    public float getGrade() {
        return grade;
    }

    public void setGrade(float grade){
        this.grade = (float) grade;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Thesis [id=" + t_id + ", title=" + title + ", description=" + description +", grade=" +grade+ "]";
    }
}
