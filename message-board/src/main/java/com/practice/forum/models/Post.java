package com.practice.forum.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Post extends BaseModel{
    private String message;
    @ManyToOne
    private Thread thread;
    @ManyToOne
    private User createdBy;
    private Date createdAt;
    @ManyToOne
    private Post replyTo;
}
