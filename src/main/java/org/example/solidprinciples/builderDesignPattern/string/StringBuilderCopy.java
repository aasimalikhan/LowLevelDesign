package org.example.solidprinciples.builderDesignPattern.string;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringBuilderCopy {
    List<String> characterArray = new ArrayList<>();

    public void append(String s) {
        characterArray.add(s);
    }

    public String build()
    {
        String s = characterArray.stream().collect(Collectors.joining(""));
        return s;
    }

}
