package com.practice.forum.exceptions;

public class ThreadNotFoundException extends RuntimeException {
    public ThreadNotFoundException() {
        super("Thread Not Found");
    }
}
