package org.example.designScenarios.designSearchFilter.service;

import org.example.designScenarios.designSearchFilter.exception.filter.FilterException;
import org.example.designScenarios.designSearchFilter.factory.NameFilterStrategyFactory;
import org.example.designScenarios.designSearchFilter.models.FileSystemResource;
import org.example.designScenarios.designSearchFilter.models.SearchRequest;
import org.example.designScenarios.designSearchFilter.strategy.datefilter.DateFilterStrategy;
import org.example.designScenarios.designSearchFilter.strategy.namefilter.NameFilterStrategy;

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
