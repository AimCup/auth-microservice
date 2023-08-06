package xyz.aimcup.example.data.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import xyz.aimcup.example.data.entity.Example;

import java.util.UUID;

@Repository
public interface ExampleRepostiory extends JpaRepository<Example, UUID> {
}
