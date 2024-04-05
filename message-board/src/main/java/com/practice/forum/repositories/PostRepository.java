package com.practice.forum.repositories;

import com.practice.forum.models.Post;
import com.practice.forum.models.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PostRepository extends JpaRepository<Post, Long> {
    public Optional<List<Post>> findByThread(Thread thread);
}
