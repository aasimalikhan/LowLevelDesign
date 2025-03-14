package org.example.caseStudies.designSearchFilter.service;

import org.example.caseStudies.designSearchFilter.exception.filter.FilterException;
import org.example.caseStudies.designSearchFilter.factory.NameFilterStrategyFactory;
import org.example.caseStudies.designSearchFilter.models.FileSystemResource;
import org.example.caseStudies.designSearchFilter.models.SearchRequest;
import org.example.caseStudies.designSearchFilter.strategy.namefilter.NameFilterStrategy;

import java.util.List;

public class NameFilterService {
    private static NameFilterService nameFilterService;

    public static NameFilterService getInstance()
    {
        if(nameFilterService == null) {
            synchronized (NameFilterService.class) {
                if(nameFilterService == null)
                {
                    nameFilterService = new NameFilterService();
                }
            }
        }
        return nameFilterService;
    }

    private final NameFilterStrategy nameFilterStrategy = NameFilterStrategyFactory.getNameFilterStrategy();

    public List<FileSystemResource> filter(List<FileSystemResource> fileSystemResourceList, SearchRequest searchRequest) throws FilterException {
        return nameFilterStrategy.filter(fileSystemResourceList, searchRequest);
    }
}
