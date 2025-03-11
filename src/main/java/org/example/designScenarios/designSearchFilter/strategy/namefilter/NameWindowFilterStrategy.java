package org.example.designScenarios.designSearchFilter.strategy.namefilter;

import org.example.designScenarios.designSearchFilter.exception.filter.NameFilterException;
import org.example.designScenarios.designSearchFilter.models.FileSystemResource;
import org.example.designScenarios.designSearchFilter.models.SearchRequest;

import java.util.List;

public class NameWindowFilterStrategy implements NameFilterStrategy{

    private boolean checkWindowExists(String fileName, String searchText)
    {
        if(fileName.length() < searchText.length())
        {
            return false;
        }
        int i = 0, j = 0;
        int fileNameLength = fileName.length();
        while(j < fileNameLength)
        {
            if(j - i + 1 == searchText.length())
            {
                String fileSubstring = fileName.substring(i, j + 1);
                if(fileSubstring.equals(searchText))
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
    public List<FileSystemResource> filter(List<FileSystemResource> fileSystemResourceList, SearchRequest searchRequest) throws NameFilterException {
        try {
            if (searchRequest == null || searchRequest.getText() == null) {
                return fileSystemResourceList;
            }
            return fileSystemResourceList.stream().filter((item) -> checkWindowExists(item.getName(), searchRequest.getText())).toList();
        } catch (Exception ex)
        {
            throw new NameFilterException("Error filtering files by name: " + ex.getMessage());
        }
    }
}
