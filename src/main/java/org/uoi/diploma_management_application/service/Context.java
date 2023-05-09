package org.uoi.diploma_management_application.service;

import org.uoi.diploma_management_application.entity.Student;

import java.util.List;

public class Context {

    private SelectionStrategy strategy;

    public Context() {
    }
    public Context(SelectionStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(SelectionStrategy strategy) {
        this.strategy = strategy;
    }

    public SelectionStrategy getStrategy() {
        return strategy;
    }

    public Student selectApplicant(List<Student> applicants) {
        return strategy.selectApplicant(applicants);
    }
}
