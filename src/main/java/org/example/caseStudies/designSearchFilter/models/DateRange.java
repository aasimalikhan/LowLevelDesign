package org.example.caseStudies.designSearchFilter.models;

import java.time.LocalDateTime;

public class DateRange {
    LocalDateTime fromDate;
    LocalDateTime toDate;

    public DateRange(LocalDateTime fromDate, LocalDateTime toDate)
    {
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public LocalDateTime getFromDate() {
        return fromDate;
    }

    public void setFromDate(LocalDateTime fromDate) {
        this.fromDate = fromDate;
    }

    public LocalDateTime getToDate() {
        return toDate;
    }

    public void setToDate(LocalDateTime toDate) {
        this.toDate = toDate;
    }
}
