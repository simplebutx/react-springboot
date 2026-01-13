package com.htm.backend.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Map;

@Controller
public class PostController {

    @PostMapping("/api/posts")
    public ResponseEntity<Void> createPost(@RequestBody Map<String, String> body) {
        System.out.println(body.get("title"));
        System.out.println(body.get("content"));
        return ResponseEntity.status(201).build();
    }
}
