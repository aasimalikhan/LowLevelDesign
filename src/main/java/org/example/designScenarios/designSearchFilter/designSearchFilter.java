package org.example.designScenarios.designSearchFilter;

import org.example.designScenarios.designSearchFilter.models.Directory;
import org.example.designScenarios.designSearchFilter.models.File;
import org.example.designScenarios.designSearchFilter.models.FileSystemResource;
import org.example.designScenarios.designSearchFilter.models.SearchRequest;
import org.example.designScenarios.designSearchFilter.service.FileSystemResourceService;

public class designSearchFilter {
    private FileSystemResourceService fileSystemResourceService;
    public designSearchFilter()
    {
        this.fileSystemResourceService = FileSystemResourceService.getInstance();
        initializeResources();
    }

    public void initializeResources()
    {
        try {
            initializeDrives();
            Directory cDrive = fileSystemResourceService.getDirectory("100001");
            initializeDirectoriesIntoDrive(cDrive);
            Directory musicDirectoryCDrive = fileSystemResourceService.getDirectory("100004");
            Directory photosDirectoryCDrive = fileSystemResourceService.getDirectory("100005");
            Directory documentsDirectoryCDrive = fileSystemResourceService.getDirectory("100006");
            Directory downloadsDirectoryCDrive = fileSystemResourceService.getDirectory("100007");
            initializeFilesIntoPhotosDirectory(photosDirectoryCDrive);
            initializeFilesIntoMusicDirectory(musicDirectoryCDrive);

        } catch (Exception ex)
        {
            System.out.println("Error initializing resources: " + ex.getMessage());
        }
    }

    public void initializeDrives()
    {
        try {
            Directory CDrive = new Directory("C");
            Directory DDrive = new Directory("D");
            Directory EDrive = new Directory("E");
            fileSystemResourceService.addDrive(CDrive);
            fileSystemResourceService.addDrive(DDrive);
            fileSystemResourceService.addDrive(EDrive);
        } catch (Exception ex)
        {
            System.out.println("Error initializing drives: " + ex.getMessage());
        }
    }

    public void initializeFilesIntoPhotosDirectory(Directory directory)
    {
        try {
            File aasimPhoto = new File("aasim.jpg");
            File emaadPhoto = new File("emaad.jpg");
            File ridaPhoto = new File("rida.jpg");
            File ahmedPhoto = new File("ahmed.jpg");
            File awaisPhoto = new File("awais.jpg");
            fileSystemResourceService.addFileSystemResources(aasimPhoto, directory);
            fileSystemResourceService.addFileSystemResources(emaadPhoto, directory);
            fileSystemResourceService.addFileSystemResources(ridaPhoto, directory);
            fileSystemResourceService.addFileSystemResources(ahmedPhoto, directory);
            fileSystemResourceService.addFileSystemResources(awaisPhoto, directory);
        } catch (Exception ex)
        {
            System.out.println("Error initializing files into photos directory: " + ex.getMessage());
        }
    }

    public void initializeFilesIntoMusicDirectory(Directory directory)
    {
        try {
            File binTereSong = new File("bin tere.mp3");
            File tereBinSong = new File("tere bin.mp3");
            File aadatSong = new File("aadat.mp3");
            File pehliDafaSong = new File("pehli dafa.mp3");
            File kyunSong = new File("kyun.mp3");

            fileSystemResourceService.addFileSystemResources(binTereSong, directory);
            fileSystemResourceService.addFileSystemResources(tereBinSong, directory);
            fileSystemResourceService.addFileSystemResources(aadatSong, directory);
            fileSystemResourceService.addFileSystemResources(pehliDafaSong, directory);
            fileSystemResourceService.addFileSystemResources(kyunSong, directory);
        } catch (Exception ex)
        {
            System.out.println("Error initializing files into music directory: " + ex.getMessage());
        }
    }

    public void initializeDirectoriesIntoDrive(Directory drive)
    {
        try {
            Directory musicDirectory = new Directory("music");
            Directory photosDirectory = new Directory("photos");
            Directory documentsDirectory = new Directory("documents");
            Directory downloadsDirectory = new Directory("downloads");
            fileSystemResourceService.addFileSystemResources(musicDirectory, drive);
            fileSystemResourceService.addFileSystemResources(photosDirectory, drive);
            fileSystemResourceService.addFileSystemResources(documentsDirectory, drive);
            fileSystemResourceService.addFileSystemResources(downloadsDirectory, drive);
        } catch (Exception ex)
        {
            System.out.println("Error initializing directories into drive: " + ex.getMessage());
        }
    }

    public void printAllContents()
    {
        try {
            System.out.println(fileSystemResourceService.getAllFileSystemResources());
        } catch (Exception ex)
        {
            System.out.println("Error fetching directory contents: " + ex.getMessage());
        }
    }

    public void printFilteredContents(SearchRequest searchRequest)
    {
        try {
            System.out.println(fileSystemResourceService.getAllFileSystemResources(searchRequest));
        } catch (Exception ex)
        {
            System.out.println("Error fetching contents: " + ex.getMessage());
        }
    }


}
