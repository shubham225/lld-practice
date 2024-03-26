package com.practice.lld.tictactoe.services.strategies;

import com.practice.lld.tictactoe.models.Board;
import com.practice.lld.tictactoe.models.Cell;
import com.practice.lld.tictactoe.models.Move;
import com.practice.lld.tictactoe.models.Player;
import com.practice.lld.tictactoe.services.GamePlayStategy;

import java.util.List;
import java.util.Random;

public class BotEasyGamePlay implements GamePlayStategy {
    @Override
    public Move play(Board board, Player player) {
        Move move = null;
        List<Cell> availableCells = board.getAvailableCells();
        Random random = new Random();
        int indx = random.nextInt();

        indx = Math.abs(indx);
        indx %= availableCells.size();

        try {
            move = Move.builder()
                    .setCell(availableCells.get(indx))
                    .setPlayer(player)
                    .build();
            board.makeMove(move);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return move;
    }
}
