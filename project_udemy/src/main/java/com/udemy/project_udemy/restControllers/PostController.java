package com.udemy.project_udemy.restControllers;

import com.udemy.project_udemy.entities.Post;
import com.udemy.project_udemy.enums.PEnum;
import com.udemy.project_udemy.services.serviceImpl.PostServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequiredArgsConstructor
@RestController
@RequestMapping("/post")
public class PostController {
    private final PostServiceImpl postService;
    @PostMapping("/add")
    public ResponseEntity<Map<PEnum,Object>> addPost(@RequestBody Post post){

        return postService.addPost(post);
    }

    @PutMapping("/update")
    public ResponseEntity<Map<PEnum,Object>> updatePost(@RequestBody Post post){

        return postService.updatePost(post);
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Map<PEnum,Object>> deletePost(@RequestParam Long id){

        return postService.deletePost(id);
    }
    @GetMapping("/getPost")
    public ResponseEntity<Map<PEnum,Object>> findPostById(@RequestParam Long id){

        return postService.findPostById(id);
    }
    @GetMapping("/getAllPost")
    public ResponseEntity<Map<PEnum,Object>> findPostAll(){

        return postService.findPostAll();
    }


}
