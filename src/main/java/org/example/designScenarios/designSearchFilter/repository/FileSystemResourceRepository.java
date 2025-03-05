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
        return drives.stream().flatMap(item -> {
            return item.getAllSubResources().stream();
        }).toList();
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

    @Override
    public Optional<FileSystemResource> getFileSystemResource(String id)
    {
        return findAllResources().stream().filter((drive) -> drive.getId().equals(id)).findFirst();
//        return drives.stream().filter((drive) -> drive.getId().equals(id)).findFirst();
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
