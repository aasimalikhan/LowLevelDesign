package org.example.designScenarios.designSearchFilter.models;

public class SearchRequest {
    private String text;
    private DateRange dateRange;

    public SearchRequest(String text, DateRange dateRange)
    {
        this.text = text;
        this.dateRange = dateRange;
    }

    public SearchRequest(String text)
    {
        this.text = text;
    }

    public SearchRequest(DateRange dateRange)
    {
        this.dateRange = dateRange;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public DateRange getDateRange() {
        return dateRange;
    }

    public void setDateRange(DateRange dateRange) {
        this.dateRange = dateRange;
    }
}
