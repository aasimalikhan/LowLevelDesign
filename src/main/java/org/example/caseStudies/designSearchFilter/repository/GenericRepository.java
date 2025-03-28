package org.example.caseStudies.designSearchFilter.repository;

import org.example.caseStudies.designSearchFilter.models.Directory;

import java.util.List;
import java.util.Optional;

public interface GenericRepository<T> {
    List<T> findAllResources();
    Optional<T> findResourceById(String id);
    T insertDrive(Directory drive);
    Optional<Directory> getDirectory(String id);
    T insertIntoDirectory(T entity, Directory directory);
    void deleteDrive(Directory drive);
}
