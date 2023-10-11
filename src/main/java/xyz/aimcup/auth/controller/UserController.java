package xyz.aimcup.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.aimcup.auth.mapper.user.UserMapper;
import xyz.aimcup.auth.service.IUserService;
import xyz.aimcup.generated.UserApi;
import xyz.aimcup.generated.model.UserResponseDTO;
import xyz.aimcup.security.domain.User;
import xyz.aimcup.security.principal.UserPrincipal;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {
    private final IUserService userService;
    private final UserMapper userMapper;

    @Override
    public ResponseEntity<UserResponseDTO> me(String authorization) {
        User user = userService.getUserFromBearerToken(authorization);
        UserResponseDTO userResponseDTO = userMapper.userToUserResponseDto(user);
        return ResponseEntity.ok(userResponseDTO);
    }


    @GetMapping("/test")
    public ResponseEntity<String> test() {
        var user = (UserPrincipal) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok(user.getUsername());
    }
}
