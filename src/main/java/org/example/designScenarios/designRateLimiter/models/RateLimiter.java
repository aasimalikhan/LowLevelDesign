package org.example.designScenarios.designRateLimiter.models;

public interface RateLimiter {
    public boolean allowRequest(String clientId);
}
