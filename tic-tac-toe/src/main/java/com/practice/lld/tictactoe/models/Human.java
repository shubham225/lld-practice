package com.practice.lld.tictactoe.models;

import com.practice.lld.tictactoe.services.GamePlayFactory;
import com.practice.lld.tictactoe.services.GamePlayStategy;
import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Human extends Player {
    public Human() {}
    public Human(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    @Override
    public Move decideAndPlayMove(Board board) {
        GamePlayStategy gamePlay = GamePlayFactory.getGamePlayStrategy(PlayerType.HUMAN);
        return gamePlay.play(board, this);
    }
}
