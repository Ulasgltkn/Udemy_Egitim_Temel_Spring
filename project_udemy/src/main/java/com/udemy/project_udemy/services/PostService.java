package com.udemy.project_udemy.services;

import com.udemy.project_udemy.entities.Post;
import com.udemy.project_udemy.enums.PEnum;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface PostService {
    public ResponseEntity<Map<PEnum,Object>> addPost(Post post);
    public ResponseEntity<Map<PEnum,Object>> updatePost(Post post);
    public ResponseEntity<Map<PEnum,Object>> deletePost(Long id);
    public ResponseEntity<Map<PEnum,Object>> findPostById(Long id);
    public ResponseEntity<Map<PEnum,Object>> findPostAll();

}
