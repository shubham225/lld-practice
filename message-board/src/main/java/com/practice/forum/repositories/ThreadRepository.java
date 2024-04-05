package com.practice.forum.repositories;

import com.practice.forum.models.Forum;
import com.practice.forum.models.Thread;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ThreadRepository extends JpaRepository<Thread, Long> {
    public Optional<List<Thread>> findByForum(Forum forum);
}
