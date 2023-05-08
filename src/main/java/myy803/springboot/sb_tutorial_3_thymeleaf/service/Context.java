package myy803.springboot.sb_tutorial_3_thymeleaf.service;

import myy803.springboot.sb_tutorial_3_thymeleaf.entity.Student;

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
