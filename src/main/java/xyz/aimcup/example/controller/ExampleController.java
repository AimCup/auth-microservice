package xyz.aimcup.example.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import xyz.aimcup.generated.ExamplesApi;
import xyz.aimcup.generated.model.ExampleDataRequest;
import xyz.aimcup.generated.model.ExampleDataResponse;
import xyz.aimcup.example.data.entity.Example;
import xyz.aimcup.example.data.repository.ExampleRepostiory;
import xyz.aimcup.example.mapper.example.ExampleMapper;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ExampleController implements ExamplesApi {

    private final ExampleRepostiory exampleRepostiory;
    private final ExampleMapper exampleMapper;

    @Override
    public ResponseEntity<String> addNewExamples(ExampleDataRequest exampleDataRequest) {
        exampleRepostiory.save(Example.builder()
                .data(exampleDataRequest.getData())
                .build());
        return ResponseEntity.ok("Example added");
    }

    @Override
    public ResponseEntity<List<ExampleDataResponse>> getExamples() {
        List<Example> examples = exampleRepostiory.findAll();
        List<ExampleDataResponse> exampleDataResponses = exampleMapper.examplesToExampleResponses(examples);
        return ResponseEntity.ok(exampleDataResponses);
    }
}
