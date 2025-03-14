package org.example.caseStudies.designSearchFilter.strategy;

import org.example.caseStudies.designSearchFilter.exception.filter.FilterException;
import org.example.caseStudies.designSearchFilter.models.FileSystemResource;
import org.example.caseStudies.designSearchFilter.models.SearchRequest;

import java.util.List;

public interface FilterStrategy {
    List<FileSystemResource> filter(List<FileSystemResource> fileSystemResourceList, SearchRequest searchRequest) throws FilterException;
}
