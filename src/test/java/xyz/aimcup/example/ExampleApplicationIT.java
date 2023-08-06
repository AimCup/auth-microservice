package xyz.aimcup.example;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import xyz.aimcup.example.reusablecontainers.DatabaseContainerIT;

@SpringBootTest
class ExampleApplicationIT extends DatabaseContainerIT {

    @Test
    @SuppressWarnings("squid:S2699")
    void contextLoads() {
    }

}
