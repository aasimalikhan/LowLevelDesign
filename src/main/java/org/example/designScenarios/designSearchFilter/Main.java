package org.example.designScenarios.designSearchFilter;

import org.example.designScenarios.designSearchFilter.models.DateRange;
import org.example.designScenarios.designSearchFilter.models.SearchRequest;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        designSearchFilter dsF = new designSearchFilter();
        dsF.printAllContents();

        SearchRequest searchRequest1 = new SearchRequest("tere", new DateRange(null, LocalDateTime.now()));
        dsF.printFilteredContents(searchRequest1);
        SearchRequest searchRequest2 = new SearchRequest("doc", new DateRange(null, LocalDateTime.now()));
        dsF.printFilteredContents(searchRequest2);
        SearchRequest searchRequest3 = new SearchRequest("down");
        dsF.printFilteredContents(searchRequest3);
    }
}
