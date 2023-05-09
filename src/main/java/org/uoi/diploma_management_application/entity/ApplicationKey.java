package org.uoi.diploma_management_application.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class ApplicationKey implements Serializable {

    @Column(name = "subject_id")
    int subjectId;

    @Column(name = "student_id")
    int studentId;

    public ApplicationKey() {

    }

    public ApplicationKey(int subjectId, int studentId) {
        this.subjectId = subjectId;
        this.studentId = studentId;
    }


}
