package com.practice.lld.tictactoe.services;

import com.practice.lld.tictactoe.models.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

public class GameService {
    public void startGame() {
        Board board = new Board(3);
        List<Player> playerList = new ArrayList<>();
        Player player1 = new HumanPlayer("pqr", 'x');
        Player player2 = new HumanPlayer("xyz", 'o');
        playerList.add(player1);
        playerList.add(player2);

        Game game = new Game(board, playerList);
        game.printGame();

        while(game.gameIsInProgress()) {
            Player player = game.getNextPlayer();
            Position position = player.play();
            Board board1 = game.getBoard();

            if(board1.markPosition(position, player)) {
                if (game.checkGameEnd(position, player))
                    break;
                game.updateNextPlayer();
                game.printGame();
            }else {
                System.out.println("Position Not Valid, Enter New Position");
            }
        }

        if(game.getStatus() == GameStatus.FINISHED) {
            game.getBoard().printBoard();
            System.out.println("Player '" + game.getWinner().getName() + "' wins");
        }else {
            System.out.println("It's a draw");
        }
    }
}
