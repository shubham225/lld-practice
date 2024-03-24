package com.practice.lld.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Player {
    private String name;
    public char symbol;

    public abstract void play();
}
