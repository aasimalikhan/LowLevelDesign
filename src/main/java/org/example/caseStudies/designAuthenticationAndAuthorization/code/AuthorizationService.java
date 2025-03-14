package org.example.caseStudies.designAuthenticationAndAuthorization.code;

public class AuthorizationService {
    public boolean hasAccess(User user, String requiredRole)
    {
        return user.getRoles().contains(requiredRole);
    }
}
