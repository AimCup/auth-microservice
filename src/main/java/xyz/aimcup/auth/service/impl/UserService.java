package xyz.aimcup.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.aimcup.auth.data.repository.UserRepository;
import xyz.aimcup.auth.security.TokenProvider;
import xyz.aimcup.auth.service.IUserService;
import xyz.aimcup.security.domain.User;
import xyz.aimcup.security.principal.UserPrincipal;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final TokenProvider tokenProvider;

    @Override
    public User getUserFromPrincipal(UserPrincipal userPrincipal) {
        return userRepository.findByOsuId(userPrincipal.getOsuId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }

    @Override
    public User getUserFromBearerToken(String token) {
        if (token == null) {
            return null;
        }
        Long osuId = tokenProvider.getUserOsuIdFromToken(token);
        return userRepository.findByOsuId(osuId).orElse(null);
    }
}
