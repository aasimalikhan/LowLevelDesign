package org.example.designScenarios.designAuthenticationAndAuthorization.code;

public class AuthorizationService {
    public boolean hasAccess(User user, String requiredRole)
    {
        return user.getRoles().contains(requiredRole);
    }
}
