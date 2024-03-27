package com.practice.lld.tictactoe.services.strategies;

import com.practice.lld.tictactoe.models.Board;
import com.practice.lld.tictactoe.models.Move;
import com.practice.lld.tictactoe.models.Player;
import com.practice.lld.tictactoe.services.GamePlayStategy;

import javax.naming.InterruptedNamingException;
import java.util.Scanner;

public class HumanGamePlay implements GamePlayStategy {
    @Override
    public Move play(Board board, Player player) {
        Move move = null;
        Scanner in = new Scanner(System.in);

//        System.out.println("Enter row : ");
//        int row = in.nextInt();
//        System.out.println("Enter col : ");
//        int col = in.nextInt();
        System.out.println("Enter Location : ");
        String location = in.next();

        String[] split = location.split(",");
        int row = Integer.parseInt(split[0]);
        int col = Integer.parseInt(split[1]);

        try {
            move = Move.builder()
                    .setCell(board.getCell(row, col))
                    .setPlayer(player)
                    .build();
            board.makeMove(move);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }

        return move;
    }
}
