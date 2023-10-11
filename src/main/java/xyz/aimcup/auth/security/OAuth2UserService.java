package xyz.aimcup.auth.security;

import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Service;
import xyz.aimcup.auth.data.repository.RoleRepository;
import xyz.aimcup.auth.data.repository.UserRepository;

import java.util.Collections;
import xyz.aimcup.security.domain.RoleName;
import xyz.aimcup.security.domain.User;
import xyz.aimcup.security.principal.UserPrincipal;

@Service
@RequiredArgsConstructor
public class OAuth2UserService extends DefaultOAuth2UserService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        return processOAuth2User(userRequest, oAuth2User);
    }

    private OAuth2User processOAuth2User(OAuth2UserRequest oAuth2UserRequest,
        OAuth2User oAuth2User) {
        OAuth2UserInfo oAuth2UserInfo = new OsuOAuth2UserInfo(oAuth2User.getAttributes());
        var user = userRepository.findByOsuId(oAuth2UserInfo.getOsuId()).map(this::updateUser)
            .orElseGet(() -> registerUser(oAuth2UserInfo));
        return UserPrincipal.create(user, oAuth2User.getAttributes());
    }

    private User updateUser(User user) {
        return userRepository.save(user);
    }

    private User registerUser(OAuth2UserInfo oAuth2UserInfo) {
        var userRole = roleRepository.findByName(RoleName.ROLE_USER)
            .orElseThrow(() -> new RuntimeException("User Role not set."));
        var user = User.builder()
            .osuId(oAuth2UserInfo.getOsuId())
            .username(oAuth2UserInfo.getUsername())
            .isRestricted(oAuth2UserInfo.isRestricted())
            .roles(Collections.singleton(userRole))
            .build();
        return userRepository.save(user);
    }
}
