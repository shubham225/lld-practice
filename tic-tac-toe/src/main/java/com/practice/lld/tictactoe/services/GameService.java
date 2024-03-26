package com.practice.lld.tictactoe.services;

import com.practice.lld.tictactoe.models.*;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    public void startGame() {
        Board board = new Board(3);
        List<Player> playerList = new ArrayList<>();
        Player player1 = new Human("shubham", 'x');
        Player player2 = new Bot("bot", 'o');
        playerList.add(player1);
        playerList.add(player2);

        Game game = new Game(board, playerList);
        game.printGame();

        while(game.gameIsInProgress()) {
            Player player = game.getNextPlayer();
            Move move = player.play(board);
            Board board1 = game.getBoard();

            if(board1.makeMove(move)) {
                if (game.checkGameEnd(move, player))
                    break;
                game.updateNextPlayer();
                game.printGame();
            }else {
                System.out.println("Position Not Valid, Enter New Position");
            }
        }

        if(game.getStatus() == GameStatus.FINISHED) {
            game.getBoard().printBoard();
            System.out.println("'" + game.getWinner().getName() + "' wins");
        }else {
            System.out.println("It's a draw");
        }
    }
}
