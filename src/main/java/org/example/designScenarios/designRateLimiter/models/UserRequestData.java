package org.example.designScenarios.designRateLimiter.models;

import java.util.Date;

public class UserRequestData {
    int tokens;
    Long timestamp;

    public int getTokens() {
        return tokens;
    }

    public void setTokens(int tokens) {
        this.tokens = tokens;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }
}
