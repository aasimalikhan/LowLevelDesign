package org.example.designScenarios.designAuthenticationAndAuthorization.code;

public class ResourceService {
    private AuthorizationService authorizationService;
    public ResourceService(AuthorizationService authorizationService)
    {
        this.authorizationService = authorizationService;
    }

    public String accessResource(User user, String requiredRole)
    {
        if(authorizationService.hasAccess(user, requiredRole))
        {
            return "Access granted to resource";
        }
        throw new RuntimeException("Access denied");
    }
}
