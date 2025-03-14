package org.example.caseStudies.designSearchFilter.strategy.namefilter;

import org.example.caseStudies.designSearchFilter.exception.filter.NameFilterException;
import org.example.caseStudies.designSearchFilter.models.FileSystemResource;
import org.example.caseStudies.designSearchFilter.models.SearchRequest;

import java.util.List;

public class NameEndingFilterStrategy implements NameFilterStrategy{
    @Override
    public List<FileSystemResource> filter(List<FileSystemResource> fileSystemResourceList, SearchRequest searchRequest) throws NameFilterException{
        try {
            if(searchRequest == null || searchRequest.getText() == null)
            {
                throw new IllegalArgumentException("Search request or search text cannot be null");
            }
            return fileSystemResourceList.stream().filter((fs) -> fs.getName().endsWith(searchRequest.getText())).toList();
        } catch (Exception ex) {
            throw new NameFilterException("Error filtering files by name: " + ex.getMessage());
        }
    }
}
