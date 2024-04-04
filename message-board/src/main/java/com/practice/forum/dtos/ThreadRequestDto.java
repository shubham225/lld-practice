package com.practice.forum.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ThreadRequestDto {
    private String title;
    private String metadata;
    private long forumId;
    private long createdById;
}
