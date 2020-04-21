package ru.job4j.tracker;

public class Engineer extends Profession {
    public Engineer() {
        super();
    }

    String task, decision;

    public String makeDecision() {
        return decision;
    }
}

