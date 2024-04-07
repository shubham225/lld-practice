package com.practice.forum.exceptions;

public class ForumNotFoundException extends RuntimeException{
    public ForumNotFoundException() {
        super("Forum Not Found");
    }
}
