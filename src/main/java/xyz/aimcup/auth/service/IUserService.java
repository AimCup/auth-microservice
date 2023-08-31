package xyz.aimcup.auth.service;

import xyz.aimcup.auth.data.entity.User;
import xyz.aimcup.auth.security.UserPrincipal;

public interface IUserService {
    User getUserFromPrincipal(UserPrincipal userPrincipal);
}
