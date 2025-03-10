package org.example.designScenarios.designSearchFilter.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemResource implements ResourceContainer{
    private List<FileSystemResource> immediateResourceList;

    public Directory(String directoryName) {
        super(directoryName);
    }

    @Override
    public void ls() {
        System.out.println(this);
    }

    @Override
    public List<FileSystemResource> getImmediateResources() {
        return this.immediateResourceList;
    }

    @Override
    public List<FileSystemResource> getAllSubResources() {
        return immediateResourceList.stream().flatMap((item) -> item.getImmediateResources().stream()).toList();
    }

    @Override
    public String toString() {
        return "Directory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", lastModifiedDate=" + lastModifiedDate +
                ", immediateResourceList=" + immediateResourceList +
                '}';
    }

    @Override
    public FileSystemResource insertImmediateResource(FileSystemResource resource) {
        if (this.immediateResourceList == null) {
            this.immediateResourceList = new ArrayList<>();
        }
        this.immediateResourceList.add(resource);

        this.setLastModifiedDate(LocalDateTime.now());
        return resource;
    }
}
