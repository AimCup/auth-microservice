package xyz.aimcup.auth.service;

import xyz.aimcup.security.domain.User;
import xyz.aimcup.security.principal.UserPrincipal;

public interface IUserService {
    User getUserFromPrincipal(UserPrincipal userPrincipal);
    User getUserFromBearerToken(String token);
}
