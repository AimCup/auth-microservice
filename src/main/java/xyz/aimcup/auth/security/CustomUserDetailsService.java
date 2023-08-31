package xyz.aimcup.auth.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AccountStatusUserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import xyz.aimcup.auth.data.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByOsuId(Long.parseLong(username))
                .map(user -> {
                    final AccountStatusUserDetailsChecker detailsChecker = new AccountStatusUserDetailsChecker();
                    UserDetails userDetails = UserPrincipal.create(user);
                    detailsChecker.check(userDetails);
                    return userDetails;
                })
                .orElseThrow(() -> new RuntimeException("User not found"));
    }
}
