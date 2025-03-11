package org.example.designScenarios.designSearchFilter.models;

import java.time.LocalDateTime;
import java.util.List;

public abstract class FileSystemResource {
    private static int idCounter = 100001;
    protected String id;
    protected String name;
    protected final LocalDateTime creationDate;
    protected LocalDateTime lastModifiedDate;
    protected List<FileSystemResource> immediateResourceList;

    public FileSystemResource(String name)
    {
        this.id = String.valueOf(idCounter++);
        this.name = name;
        this.creationDate = LocalDateTime.now();
        this.lastModifiedDate = LocalDateTime.now();
    }

    public String getId()
    {
        return this.id;
    }

    public String getName()
    {
        return this.name;
    }

    public void setName(String name)
    {
        this.name = name;
        this.setLastModifiedDate(LocalDateTime.now());
    }

    public LocalDateTime getCreationDate() {
        return creationDate;
    }

    public LocalDateTime getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(LocalDateTime lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public abstract void ls();
    public abstract List<FileSystemResource> getImmediateResources();

    public abstract List<FileSystemResource> getAllSubResources();
}
