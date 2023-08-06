package xyz.aimcup.auth.reusablecontainers;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.utility.DockerImageName;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public abstract class DatabaseContainerIT {

    private static final String POSTGRES_VERSION = "postgres:latest";
    private static final PostgreSQLContainer<?> postgreSQLContainer;

    static {
        postgreSQLContainer =
                new PostgreSQLContainer<>(DockerImageName.parse(POSTGRES_VERSION))
                        .withDatabaseName("test-db")
                        .withUsername("test-username")
                        .withPassword("test-password");

        postgreSQLContainer.start();
    }

    @DynamicPropertySource
    static void datasourceConfig(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
        registry.add("spring.datasource.password", postgreSQLContainer::getPassword);
        registry.add("spring.datasource.username", postgreSQLContainer::getUsername);
    }
}
