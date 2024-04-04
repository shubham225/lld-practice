package com.practice.forum.dtos;


import com.practice.forum.models.User;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class ForumRequestDto {
    private String title;
    private String metadata;
    private long createdById;
}
