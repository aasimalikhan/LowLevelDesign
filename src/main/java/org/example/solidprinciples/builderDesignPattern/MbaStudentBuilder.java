package org.example.solidprinciples.builderDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class MbaStudentBuilder extends StudentBuilder{
    @Override
    public StudentBuilder setSubjects(List<String> subjects) {
        List<String> subs = new ArrayList<>();
        subs.add("Micro Economics");
        subs.add("Business Studies");
        subs.add("Operations Management");
        this.subjects = subs;
        return this;
    }
}
