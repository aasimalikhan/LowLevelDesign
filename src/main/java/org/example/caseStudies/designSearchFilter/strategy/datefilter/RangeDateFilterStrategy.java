package org.example.caseStudies.designSearchFilter.strategy.datefilter;

import org.example.caseStudies.designSearchFilter.exception.filter.DateFilterException;
import org.example.caseStudies.designSearchFilter.models.FileSystemResource;
import org.example.caseStudies.designSearchFilter.models.SearchRequest;

import java.time.LocalDateTime;
import java.util.List;

public class RangeDateFilterStrategy implements DateFilterStrategy{
    @Override
    public List<FileSystemResource> filter(List<FileSystemResource> fileSystemResourceList, SearchRequest searchRequest) throws DateFilterException{
        try {
            if(searchRequest == null || searchRequest.getDateRange() == null)
            {
                return fileSystemResourceList;
            }
            LocalDateTime fromDate = searchRequest.getDateRange().getFromDate();
            LocalDateTime toDate = searchRequest.getDateRange().getToDate();

            return fileSystemResourceList.stream().filter(item -> {

                LocalDateTime modifiedDateTime = item.getLastModifiedDate();

                if(modifiedDateTime == null)
                {
                    return false;
                }
                boolean afterFromDate = (fromDate == null) || (modifiedDateTime.isAfter(fromDate)) || (modifiedDateTime.isEqual(fromDate));
                boolean beforeToDate = (toDate == null) || (modifiedDateTime.isBefore(toDate)) || (modifiedDateTime.isEqual(toDate));

                return afterFromDate && beforeToDate;
            }).toList();
        } catch (Exception ex)
        {
            throw new DateFilterException("Error filtering files by date: " + ex.getMessage());
        }
    }
}
