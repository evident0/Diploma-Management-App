package org.uoi.diploma_management_application.entity;


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

    @OneToMany(mappedBy = "subject", cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    private List<Application> applications = new ArrayList<>();

    public Subject() {

    }

    @OneToOne(mappedBy = "subject", fetch = FetchType.LAZY)
    private Thesis thesis;

    public Subject(int subjectId, String title, String description) {
        this.subjectId = subjectId;
        this.title = title;
        this.description = description;
    }

    public Subject(String title, String description) {
        this.title = title;
        this.description = description;
    }

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

    public Professor getProfessor() {
        return professor;
    }

    public void setThesis(Thesis thesis) {
    	this.thesis = thesis;
    }

    public Thesis getThesis() {
    	return thesis;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Application> getApplications(){
        return applications;
    }

    public void setApplications(List<Application> applications){
        this.applications = applications;
    }

    @Override
    public String toString() {
        return "Subject [id=" + subjectId + ", title=" + title + ", " +
                "description=" + description + "prof=" + professor + "]";
    }

}
