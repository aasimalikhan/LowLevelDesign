package org.example.caseStudies.designSearchFilter.service;

import org.example.caseStudies.designSearchFilter.exception.filter.FilterException;
import org.example.caseStudies.designSearchFilter.models.FileSystemResource;
import org.example.caseStudies.designSearchFilter.models.SearchRequest;

import java.util.List;

public class FilterService {
    private static FilterService filterService;

    public static FilterService getInstance()
    {
        if(filterService == null) {
            synchronized (FilterService.class) {
                if(filterService == null)
                {
                    filterService = new FilterService();
                }
            }
        }
        return filterService;
    }
    public List<FileSystemResource> filter(List<FileSystemResource> fileSystemResourceList, SearchRequest searchRequest) throws FilterException {
        try {
            fileSystemResourceList = DateFilterService.getInstance().filter(fileSystemResourceList, searchRequest);
            fileSystemResourceList = NameFilterService.getInstance().filter(fileSystemResourceList, searchRequest);
            return fileSystemResourceList;
        } catch (Exception ex)
        {
            throw new FilterException("Error filtering files: " + ex.getMessage());
        }
    }
}
