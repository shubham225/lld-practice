package com.practice.forum.services;

import com.practice.forum.dtos.ThreadRequestDto;
import com.practice.forum.models.Thread;
import org.springframework.stereotype.Service;

@Service
public class ThreadService {
    public Thread addThread(ThreadRequestDto threadRequestDto) {
        Thread thread = new Thread();
        thread.setTitle("Thread-1");
        return thread;
    }
}
