package org.example.solidprinciples.builderDesignPattern.string;

public class builderDesignPatternCode {
    public static void main(String[] args) {
        StringBuilderCopy stringBuilderCopy = new StringBuilderCopy();
        stringBuilderCopy.append("aa");
        stringBuilderCopy.append("bb");
        stringBuilderCopy.append("cc");

        String str = stringBuilderCopy.build();
        System.out.println(str);
    }
}
