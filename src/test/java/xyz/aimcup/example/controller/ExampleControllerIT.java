package xyz.aimcup.example.controller;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import xyz.aimcup.generated.model.ExampleDataRequest;
import xyz.aimcup.generated.model.ExampleDataResponse;
import xyz.aimcup.example.reusablecontainers.DatabaseContainerIT;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
class ExampleControllerIT extends DatabaseContainerIT {
    @Autowired
    private ExampleController exampleController;

    @Test
    void shouldAddExampleToDatabase() {
        // given
        ExampleDataRequest exampleDataRequest = new ExampleDataRequest();
        exampleDataRequest.setData("example data");

        // when
        String response = exampleController.addNewExamples(exampleDataRequest).getBody();

        // then
        assertThat(response).isEqualTo("Example added");
    }

    @Test
    void shouldFindOnlyOneExampleInDatabase() {
        // given
        ExampleDataRequest exampleDataRequest = new ExampleDataRequest();
        exampleDataRequest.setData("example data 2");

        // when
        exampleController.addNewExamples(exampleDataRequest).getBody();
        exampleController.addNewExamples(exampleDataRequest).getBody();
        List<ExampleDataResponse> exampleList = exampleController.getExamples().getBody();

        // then
        assertThat(exampleList).hasSizeGreaterThan(1);
    }
}