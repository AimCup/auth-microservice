package xyz.aimcup.auth.service;

import xyz.aimcup.auth.security.UserPrincipal;
import xyz.aimcup.security.domain.User;

public interface IUserService {
    User getUserFromPrincipal(UserPrincipal userPrincipal);
    User getUserFromBearerToken(String token);
}
