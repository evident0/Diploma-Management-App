package org.uoi.diploma_management_application.service;

import org.uoi.diploma_management_application.entity.Student;

import java.util.List;

public class ThresholdSelection implements SelectionStrategy{

    private float minAVG;
    private int maxRemaining;

    public ThresholdSelection(float minAVG, int maxRemaining){
        this.minAVG = minAVG;
        this.maxRemaining = maxRemaining;
    }

    @Override
    public Student selectApplicant(List<Student> applicants) {
        Student selected = null;
        for (Student applicant : applicants) {
            if (applicant.getAverageGrade() >= minAVG && applicant.getRemainingCourses() <= maxRemaining) {
                selected = applicant;
            }
        }
        return selected;
    }
}
