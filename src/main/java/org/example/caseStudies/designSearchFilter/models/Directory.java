package org.example.caseStudies.designSearchFilter.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Directory extends FileSystemResource implements ResourceContainer{
    private List<FileSystemResource> immediateResourceList;

    public Directory(String directoryName) {
        super(directoryName);
        this.immediateResourceList = new ArrayList<>();
    }

    @Override
    public Long getSize() {
        List<FileSystemResource> subResources = getAllSubResources();
        return subResources.stream()
                .mapToLong(resource -> resource.getSize() != null ? resource.getSize() : 0L)
                .sum();
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
        if(immediateResourceList == null || immediateResourceList.isEmpty())
        {
            return new ArrayList<>();
        }

        List<FileSystemResource> allResources = new ArrayList<>(immediateResourceList);

        List<FileSystemResource> subResources = new ArrayList<>();
        for(FileSystemResource resource : immediateResourceList)
        {
            subResources.addAll(resource.getAllSubResources());
        }
        allResources.addAll(subResources);
        return allResources;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", creationDate=" + creationDate +
                ", size=" + this.getSize() +
                ", lastModifiedDate=" + lastModifiedDate +
                ", immediateResourceList=" + immediateResourceList +
                ", subRecordCount= " + this.getAllSubResources().size() +
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
