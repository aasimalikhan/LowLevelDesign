package org.example.designScenarios.designSearchFilter.strategy.datefilter;

import org.example.designScenarios.designSearchFilter.exception.filter.DateFilterException;
import org.example.designScenarios.designSearchFilter.exception.filter.NameFilterException;
import org.example.designScenarios.designSearchFilter.models.FileSystemResource;
import org.example.designScenarios.designSearchFilter.models.SearchRequest;

import java.util.List;

public class RangeDateFilterStrategy implements DateFilterStrategy{
    @Override
    public List<FileSystemResource> filter(List<FileSystemResource> fileSystemResourceList, SearchRequest searchRequest) throws DateFilterException{
        try {
            if(searchRequest == null || searchRequest.getDateRange() == null)
            {
                throw new IllegalArgumentException("Search request or search date range cannot be null");
            }
            return fileSystemResourceList.stream().filter((item) -> (searchRequest.getDateRange().getFromDate() == null || item.getLastModifiedDate().isAfter(searchRequest.getDateRange().getFromDate())) &&
                    (searchRequest.getDateRange().getToDate() == null || item.getLastModifiedDate().isBefore(searchRequest.getDateRange().getToDate()))).toList();
        } catch (Exception ex)
        {
            throw new DateFilterException("Error filtering files by date: " + ex.getMessage());
        }
    }
}
