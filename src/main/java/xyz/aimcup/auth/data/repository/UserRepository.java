package xyz.aimcup.auth.data.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import xyz.aimcup.security.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByOsuId(Long osuId);
}
