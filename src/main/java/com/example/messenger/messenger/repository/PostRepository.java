package com.example.messenger.messenger.repository;

import com.example.messenger.messenger.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
}
