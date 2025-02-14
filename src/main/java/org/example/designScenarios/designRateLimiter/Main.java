package org.example.designScenarios.designRateLimiter;

import org.example.designScenarios.designRateLimiter.models.RateLimiter;
import org.example.designScenarios.designRateLimiter.models.TokenBucketRateLimiter;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        RateLimiter rateLimiter = new TokenBucketRateLimiter();
        String clientId = "1";
        for(int i = 0; i < 23; i++)
        {
            if(rateLimiter.allowRequest(clientId))
            {
                System.out.println("Request allowed");
            }
            else
            {
                System.out.println("Request blocked");
            }
        }
        Thread.sleep(1000);
        for(int i = 0; i < 10; i++)
        {
            if(rateLimiter.allowRequest(clientId))
            {
                System.out.println("Request allowed");
            }
            else
            {
                System.out.println("Request blocked");
            }
        }
    }
}
