package com.example.intro_spring_framework.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello") // localhost:8080/hello - endpoint path
    public String sayHello(@RequestParam(value = "name", required = false, defaultValue = "Unknown") String name){
            // http://localhost:8080/hello?name=Ivan
        return String.format("Hello %s, from Spring MVC!", name);
    }

    @GetMapping("/users/{userId}/posts/{postId}") // template/path parameter
    public String getPost(@PathVariable Integer userId, @PathVariable Integer postId){
            // http://localhost:8080/users/10/posts/15
        return String.format("User: %d --> Post: %d%n", userId, postId);
    }



}
