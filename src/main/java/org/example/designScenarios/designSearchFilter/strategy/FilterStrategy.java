package org.example.designScenarios.designSearchFilter.strategy;

import org.example.designScenarios.designSearchFilter.exception.filter.FilterException;
import org.example.designScenarios.designSearchFilter.models.FileSystemResource;
import org.example.designScenarios.designSearchFilter.models.SearchRequest;

import java.util.List;

public interface FilterStrategy {
    List<FileSystemResource> filter(List<FileSystemResource> fileSystemResourceList, SearchRequest searchRequest) throws FilterException;
}
