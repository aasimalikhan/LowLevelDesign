package org.example.designScenarios.designSearchFilter.service;

import org.example.designScenarios.designSearchFilter.exception.filter.FilterException;
import org.example.designScenarios.designSearchFilter.factory.DateFilterStrategyFactory;
import org.example.designScenarios.designSearchFilter.models.FileSystemResource;
import org.example.designScenarios.designSearchFilter.models.SearchRequest;
import org.example.designScenarios.designSearchFilter.strategy.datefilter.DateFilterStrategy;

import java.util.List;

public class DateFilterService {
    private static DateFilterService dateFilterService;

    public static DateFilterService getInstance()
    {
        if(dateFilterService == null) {
            synchronized (DateFilterService.class) {
                if(dateFilterService == null)
                {
                    dateFilterService = new DateFilterService();
                }
            }
        }
        return dateFilterService;
    }

    private final DateFilterStrategy dateFilterStrategy = DateFilterStrategyFactory.getDateFilterStrategy();

    public List<FileSystemResource> filter(List<FileSystemResource> fileSystemResourceList, SearchRequest searchRequest) throws FilterException {
        return dateFilterStrategy.filter(fileSystemResourceList, searchRequest);
    }
}
