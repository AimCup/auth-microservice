package xyz.aimcup.auth.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.aimcup.auth.mapper.example.UserMapper;
import xyz.aimcup.auth.service.IUserService;
import xyz.aimcup.generated.UserApi;
import xyz.aimcup.generated.model.UserResponseDTO;
import xyz.aimcup.security.domain.User;

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
}
