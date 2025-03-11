package org.example.designScenarios.designSearchFilter.repository;

import org.example.designScenarios.designSearchFilter.models.Directory;
import org.example.designScenarios.designSearchFilter.models.FileSystemResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

public class FileSystemResourceRepository implements GenericRepository<FileSystemResource> {
    private static FileSystemResourceRepository fileSystemResourceRepository;

    public static FileSystemResourceRepository getInstance()
    {
        if(fileSystemResourceRepository == null)
        {
            synchronized (FileSystemResourceRepository.class) {
                if(fileSystemResourceRepository == null)
                {
                    fileSystemResourceRepository = new FileSystemResourceRepository();
                }
            }
        }
        return fileSystemResourceRepository;
    }

    List<Directory> drives;
    @Override
    public List<FileSystemResource> findAllResources() {
        if(drives == null)
        {
            return new ArrayList<>();
        }
        List<FileSystemResource> allResources = new ArrayList<>(drives);

        drives.forEach((drive) ->
                allResources.addAll(drive.getAllSubResources()));
        return allResources;
    }

    @Override
    public Optional<FileSystemResource> findResourceById(String id) {
        return findAllResources().stream().filter((item) -> Objects.equals(item.getId(), id)).findFirst();
    }

    @Override
    public FileSystemResource insertDrive(Directory entity) {
        if(drives == null)
        {
            drives = new ArrayList<>();
        }
        drives.add(entity);
        return entity;
    }

    public Optional<Directory> getDirectory(String id)
    {
        return findAllResources().stream().filter((directory) -> (directory.getId().equals(id) && directory instanceof Directory)).map((directory) -> (Directory) directory).findFirst();
    }

    @Override
    public FileSystemResource insertIntoDirectory(FileSystemResource entity, Directory directory) {
        return directory.insertImmediateResource(entity);
    };

    @Override
    public void deleteDrive(Directory directory) {
        drives.remove(directory);
    }
}
