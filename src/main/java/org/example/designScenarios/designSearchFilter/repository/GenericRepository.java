package org.example.designScenarios.designSearchFilter.repository;

import org.example.designScenarios.designSearchFilter.models.Directory;
import org.example.designScenarios.designSearchFilter.models.FileSystemResource;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T> {
    List<T> findAllResources();
    Optional<T> findResourceById(String id);
    T insertDrive(Directory drive);
    Optional<FileSystemResource> getFileSystemResource(String id);
    T insertIntoDirectory(T entity, Directory directory);
    void deleteDrive(Directory drive);
}
