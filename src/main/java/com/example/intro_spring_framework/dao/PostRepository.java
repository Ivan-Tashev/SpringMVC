package com.example.intro_spring_framework.dao;

import com.example.intro_spring_framework.Entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
