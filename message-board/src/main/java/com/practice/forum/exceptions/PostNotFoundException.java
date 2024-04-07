package com.practice.forum.exceptions;

public class PostNotFoundException extends RuntimeException {
    public PostNotFoundException() {
        super("Post Not Found");
    }
}
