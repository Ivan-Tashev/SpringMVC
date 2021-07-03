package com.example.intro_spring_framework.init;

import com.example.intro_spring_framework.Entity.Post;
import com.example.intro_spring_framework.dao.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {
    @Autowired
    private PostRepository postRepo;

    @Override
    public void run(String... args) throws Exception {
        if(postRepo.count() == 0) {
        List.of(
                new Post("New in Spring", "Spring Boot is fancy...", "John Smith", Set.of("spring", "java")),
                new Post("Reactive Spring", "Web Flux is here...", "John Smith", Set.of("react", "java")),
                new Post("Easy to Test", "Web test client is easy...", "John Smith", Set.of("web", "client"))
        ).forEach(postRepo::save);
        }
    }
}
