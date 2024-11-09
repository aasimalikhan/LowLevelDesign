package org.example.solidprinciples.compositeDesignPattern.fileSystemGoodCode;

public class File implements FileSystem{
    String fileName;
    public File(String fileName)
    {
        this.fileName = fileName;
    }
    public void ls()
    {
        System.out.println("file Name: " + fileName);
    }
}
