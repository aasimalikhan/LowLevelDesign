package org.example.caseStudies.designSearchFilter.service;

import org.example.caseStudies.designSearchFilter.exception.resource.FileSystemResourceInsertException;
import org.example.caseStudies.designSearchFilter.exception.resource.FileSystemResourceRetrieveException;
import org.example.caseStudies.designSearchFilter.models.Directory;
import org.example.caseStudies.designSearchFilter.models.FileSystemResource;
import org.example.caseStudies.designSearchFilter.models.SearchRequest;
import org.example.caseStudies.designSearchFilter.repository.FileSystemResourceRepository;

import java.util.List;
import java.util.Optional;

public class FileSystemResourceService {
    private static FileSystemResourceService fileSystemResourceService;

    public static FileSystemResourceService getInstance()
    {
        if(fileSystemResourceService == null)
        {
            synchronized (FileSystemResourceService.class)
            {
                if(fileSystemResourceService == null)
                {
                    fileSystemResourceService = new FileSystemResourceService();
                }
            }
        }
        return fileSystemResourceService;
    }

    public List<FileSystemResource> getAllFileSystemResources() throws FileSystemResourceRetrieveException {
        try {
            return FileSystemResourceRepository.getInstance().findAllResources();
        } catch (Exception ex)
        {
            throw new FileSystemResourceRetrieveException("Error retrieving resources: " + ex.getMessage());
        }
    }

    public List<FileSystemResource> getAllFileSystemResources(SearchRequest searchRequest) throws FileSystemResourceRetrieveException {
        try {
            List<FileSystemResource> fileSystemResourceList = getAllFileSystemResources();
            fileSystemResourceList = FilterService.getInstance().filter(fileSystemResourceList, searchRequest);
            return fileSystemResourceList;
        } catch (Exception ex)
        {
            throw new FileSystemResourceRetrieveException("Error retrieving filtered resources: " + ex.getMessage());
        }
    }

    public List<FileSystemResource> getAllFileSystemResources(Directory directory, SearchRequest searchRequest) throws FileSystemResourceRetrieveException {
        try {
            return directory.getAllSubResources();
        } catch (Exception ex)
        {
            throw new FileSystemResourceRetrieveException("Error retrieving resources: " + ex.getMessage());
        }
    }

    public void addDrive(Directory drive) throws FileSystemResourceInsertException {
        try {
            FileSystemResourceRepository.getInstance().insertDrive(drive);
        } catch (Exception ex)
        {
            throw new FileSystemResourceInsertException("Error adding drive: " + ex.getMessage());
        }
    }

    public Directory getDirectory(String id) throws FileSystemResourceInsertException {
        try {
            Optional<Directory> directory = FileSystemResourceRepository.getInstance().getDirectory(id);
            if(directory.isPresent())
            {
                return directory.get();
            }
            throw new Exception("Directory with id: " + id + " not found");
        } catch (Exception ex)
        {
            throw new FileSystemResourceInsertException("Error retrieving directory: " + ex.getMessage());
        }
    }

    public void addFileSystemResources(FileSystemResource resource, Directory directory) throws FileSystemResourceInsertException {
        try {
            FileSystemResourceRepository.getInstance().insertIntoDirectory(resource, directory);
        } catch (Exception ex) {
            throw new FileSystemResourceInsertException("Error inserting into directory: " + ex.getMessage());
        }
    }
}
