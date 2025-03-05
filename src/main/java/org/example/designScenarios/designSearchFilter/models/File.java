package org.example.designScenarios.designSearchFilter.models;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;

public class File extends FileSystemResource {

    public File(String fileName) {
        super(fileName);
    }

    @Override
    public void ls() {
        System.out.println(this);
    }

    @Override
    public List<FileSystemResource> getImmediateResources() {
        return Collections.emptyList();
    }

    @Override
    public List<FileSystemResource> getAllSubResources() {
        return Collections.emptyList();
    }

    @Override
    public String toString() {
        return "File{" +
                "id='" + id + '\'' +
                ", fileName='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", lastModifiedDate=" + lastModifiedDate +
                '}';
    }
}
