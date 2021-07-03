package com.example.intro_spring_framework.web;

import com.example.intro_spring_framework.Entity.Post;
import com.example.intro_spring_framework.dao.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/api/posts")
public class PostController {
    @Autowired
    private PostRepository postRepo;

    @GetMapping // get Post's from DB, endpoint /api/posts
    public Collection<Post> getAllPosts() {
        return postRepo.findAll();
    }

    @GetMapping("/{id}") // GET Post by Id from DB, endpoint /api/users/{id}
    public Post getPostById(@PathVariable Long id) {
        return postRepo.findById(id).orElseThrow();
    }

    @PostMapping // POST (add/save/persist) Post to the the DB, endpoint /api/posts
    @ResponseStatus(HttpStatus.CREATED)
    public Post addPost(@RequestBody Post post){
        return postRepo.save(post);
    }

    @DeleteMapping("/{id}") // DELETE Post by Id, endpoint /api/users/{id}
    @ResponseStatus(HttpStatus.OK)
    public void deletePost(@PathVariable Long id) {
        postRepo.deleteById(id);
    }
}
