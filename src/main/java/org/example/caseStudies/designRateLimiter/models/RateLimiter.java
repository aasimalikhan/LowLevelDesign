package org.example.caseStudies.designRateLimiter.models;

public interface RateLimiter {
    public boolean allowRequest(String clientId);
}
