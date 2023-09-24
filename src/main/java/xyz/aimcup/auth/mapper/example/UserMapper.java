package xyz.aimcup.auth.mapper.example;

import org.mapstruct.Mapper;
import xyz.aimcup.generated.model.UserResponseDTO;
import xyz.aimcup.security.domain.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserResponseDTO userToUserResponseDto(User user);
}
