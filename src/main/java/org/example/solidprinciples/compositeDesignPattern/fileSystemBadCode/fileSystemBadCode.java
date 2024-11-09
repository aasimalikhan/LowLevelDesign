package org.example.solidprinciples.compositeDesignPattern.fileSystemBadCode;

public class fileSystemBadCode {
    public static void main(String[] args) {
        Directory rootDirectory = new Directory("C");
        File file1 = new File("notes1.txt");
        File file2 = new File("notes2.txt");
        File file3 = new File("notes3.txt");

        rootDirectory.add(file1);
        rootDirectory.add(file2);
        rootDirectory.add(file3);

        Directory rootSubDirectory1 = new Directory("A");
        Directory rootSubDirectory2 = new Directory("B");

        rootDirectory.add(rootSubDirectory1);
        rootDirectory.add(rootSubDirectory2);

        rootDirectory.ls();
    }
}
