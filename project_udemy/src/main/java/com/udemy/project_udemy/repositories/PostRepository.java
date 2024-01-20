package com.udemy.project_udemy.repositories;

import com.udemy.project_udemy.entities.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PostRepository extends JpaRepository<Post, Long> {


}