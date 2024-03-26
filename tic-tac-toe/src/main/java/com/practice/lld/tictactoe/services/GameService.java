package com.practice.lld.tictactoe.services;

import com.practice.lld.tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    public void startGame() {
        Board board = new Board(3);
        List<Player> playerList = new ArrayList<>();
        Player player1 = new Human("Shubham", 'X');
        Player player2 = new Bot("Bot", 'O');
        playerList.add(player1);
        playerList.add(player2);

        Game game = new Game(board, playerList);
        game.printGame();

        while(game.gameIsInProgress()) {
            if(game.play()) {
                if (game.checkGameEnd(game.getLastMove(), game.getCurrentPlayer()))
                    break;

                game.askUndo();
                game.updateNextPlayer();
                game.printGame();
            }else {
                System.out.println("Position Not Valid, Enter New Position");
            }
        }

        if(game.getStatus() == GameStatus.FINISHED) {
            System.out.println(" ");
            System.out.println("-----------------------------");
            game.getBoard().printBoard();
            System.out.println("'" + game.getWinner().getName() + "' wins");
            System.out.println("-----------------------------");
        }else {
            System.out.println("It's a draw");
        }
    }
}
