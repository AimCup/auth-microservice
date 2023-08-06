package xyz.aimcup.auth;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.aimcup.auth.reusablecontainers.DatabaseContainerIT;

@SpringBootTest
class AuthApplicationIT extends DatabaseContainerIT {

    @Test
    @SuppressWarnings("squid:S2699")
    void contextLoads() {
    }

}
