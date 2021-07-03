package com.example.intro_spring_framework.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

// Lombok setup:
// Preferences | Build, Execution, Deployment | Compiler | Annotation Processors | check: Enable annotation processing
@Entity
@Data // Lombok: generates Ctor, Getters, Setters, hashCode, equal, toString
@NoArgsConstructor // Lombok Ctors...
@RequiredArgsConstructor
@AllArgsConstructor
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull // Lombok - set field to NOT NULL
    private String title;
    @NonNull
    private String content;
    @NonNull
    private String author;
    @NonNull
    @ElementCollection
    private Set<String> keywords = new HashSet<>();
    Date created = new Date();
    Date modified = new Date();

    public Post(@NonNull String title, @NonNull String content, @NonNull String author, @NonNull Set<String> keywords) {
        this.title = title;
        this.content = content;
        this.author = author;
        this.keywords = keywords;
    }
}
