package com.practice.forum.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
public class Thread extends BaseModel{
    private String title;
    private String metadata;
    @ManyToOne
    private Forum forum;
    @ManyToOne
    private User createdBy;
    private Date createdAt;
}
