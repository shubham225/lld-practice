package com.practice.lld.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
public class Bot extends Player {
    @Override
    public Position play() {
        return new Position(1, 2);
    }
}
