package com.practice.forum.dtos;


import com.practice.forum.models.Thread;
import com.practice.forum.models.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequestDto {
    private String message;
    private long threadId;
    private long createdById;
    private long replyToPostId;
}
