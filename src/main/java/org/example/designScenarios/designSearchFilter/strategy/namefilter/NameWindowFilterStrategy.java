package org.example.designScenarios.designSearchFilter.strategy.namefilter;

import org.example.designScenarios.designSearchFilter.models.FileSystemResource;
import org.example.designScenarios.designSearchFilter.models.SearchRequest;

import java.util.List;

public class NameWindowFilterStrategy implements NameFilterStrategy{

    private boolean checkWindowExists(String fileName, String searchText)
    {
        int i = 0, j = 0;
        int fileNameLength = fileName.length();
        while(j < fileNameLength)
        {
            if(j - i + 1 == searchText.length())
            {
                if(fileName.substring(i, j - i + 1).equals(searchText))
                {
                    return true;
                }
                i++;
            }
            j++;
        }
        return false;
    }
    @Override
    public List<FileSystemResource> filter(List<FileSystemResource> fileSystemResourceList, SearchRequest searchRequest) {
        return fileSystemResourceList.stream().filter((item) -> checkWindowExists(item.getName(), searchRequest.getText())).toList();
    }
}
