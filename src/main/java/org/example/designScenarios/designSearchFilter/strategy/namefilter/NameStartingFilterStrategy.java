package org.example.designScenarios.designSearchFilter.strategy.namefilter;

import org.example.designScenarios.designSearchFilter.exception.filter.NameFilterException;
import org.example.designScenarios.designSearchFilter.models.FileSystemResource;
import org.example.designScenarios.designSearchFilter.models.SearchRequest;

import java.util.List;

public class NameStartingFilterStrategy implements NameFilterStrategy{

    @Override
    public List<FileSystemResource> filter(List<FileSystemResource> fileSystemResourceList, SearchRequest searchRequest) throws NameFilterException {
        try {
            if(searchRequest == null || searchRequest.getText() == null)
            {
                throw new IllegalArgumentException("Search request or search text cannot be null");
            }
            return fileSystemResourceList.stream().filter((fs) -> fs.getName().startsWith(searchRequest.getText())).toList();
        } catch (Exception ex)
        {
            throw new NameFilterException("Error filtering files by name: " + ex.getMessage());
        }
    }
}
