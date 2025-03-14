package org.example.caseStudies.designRateLimiter.models;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TokenBucketRateLimiter implements RateLimiter{
    Map<String, UserRequestData> requestTokenMapping;

    public TokenBucketRateLimiter()
    {
        requestTokenMapping = new ConcurrentHashMap<>();
    }
    @Override
    public boolean allowRequest(String clientId) {
        //if the user is sending request for first time
        if(!requestTokenMapping.containsKey(clientId))
        {
            UserRequestData requestData = new UserRequestData();
            requestData.setTokens(9);
            Long currentTime = System.currentTimeMillis();
            requestData.setTimestamp(currentTime);
            requestTokenMapping.put(clientId, requestData);
            return true;
        }
        else
        {
            UserRequestData requestData = requestTokenMapping.get(clientId);
            //check if the current window has valid tokens
            if(requestData.getTokens() > 0)
            {
                requestData.setTokens(requestData.getTokens() - 1);
                return true;
            }
            //check whether a new window can be constructed
            else {
                Long currentTime = System.currentTimeMillis();
                Long windowRequestTimestamp = requestData.getTimestamp();
                if(currentTime - windowRequestTimestamp >= 1000)
                {
                    requestData.setTokens(10);
                    requestData.setTimestamp(currentTime);
                    return true;
                }
            }
        }
        return false;
    }
}
