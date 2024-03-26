package com.practice.lld.tictactoe.models;

import com.practice.lld.tictactoe.services.GamePlayFactory;
import com.practice.lld.tictactoe.services.GamePlayStategy;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Bot extends Player {
    public Bot(String name, String symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    @Override
    public Move decideAndPlayMove(Board board) {
        GamePlayStategy gamePlay = GamePlayFactory.getGamePlayStrategy(PlayerType.BOT_EASY);
        return gamePlay.play(board, this);
    }
}
