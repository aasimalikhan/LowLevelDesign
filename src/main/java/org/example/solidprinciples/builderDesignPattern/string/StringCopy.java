package org.example.solidprinciples.builderDesignPattern.string;

public class StringCopy {
    String s;
    public StringCopy(StringBuilderCopy stringBuilderCopy)
    {
         this.s = stringBuilderCopy.build().toString();
    }
}
