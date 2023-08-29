package xyz.aimcup.auth.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import xyz.aimcup.auth.security.UserPrincipal;
import xyz.aimcup.generated.UserApi;
import xyz.aimcup.generated.model.UserResponseDTO;

@RestController
@RequiredArgsConstructor
public class UserController implements UserApi {

    private final HttpServletRequest httpRequest;

    @Override
    public ResponseEntity<UserResponseDTO> getUser() {
        httpRequest.getRequestURI();
        return null;
    }
}
