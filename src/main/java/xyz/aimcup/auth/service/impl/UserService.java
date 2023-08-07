package xyz.aimcup.auth.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import xyz.aimcup.auth.data.entity.User;
import xyz.aimcup.auth.data.repository.UserRepository;
import xyz.aimcup.auth.security.UserPrincipal;
import xyz.aimcup.auth.service.IUserService;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {
    private final UserRepository userRepository;

    @Override
    public User getUserFromPrincipal(UserPrincipal userPrincipal) {
        return userRepository.findByOsuId(userPrincipal.getOsuId())
                .orElseThrow(() -> new RuntimeException("User not found!"));
    }
}
