package com.practice.lld.tictactoe.models;

import com.practice.lld.tictactoe.services.PlayService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
public class Game {
    private Board board;
    private int noOfPlayers;
    private Player winner;
    private int nextPlayerId;
    private GameStatus status;
    private List<Player> players;

    public Game() {}
    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        noOfPlayers = this.players.size();
        status = GameStatus.IN_PROGRESS;
        nextPlayerId = 0;
        winner = null;
    }

    public Player getNextPlayer() {
        return players.get(nextPlayerId);
    }

    public void updateNextPlayer() {
        nextPlayerId = (nextPlayerId + 1) % (players.size());
    }

    public boolean gameIsInProgress() {
        return (status == GameStatus.IN_PROGRESS);
    }

    public boolean play() {
        Player player = getNextPlayer();
        Position position = player.play(board);
        return board.markPosition(position, player);
    }

    public void printGame() {
        System.out.println("Plying Player : " + getNextPlayer().getName());
        board.printBoard();
    }

    public boolean checkGameEnd(Position position, Player player) {
        status = board.checkWin(position, player);
        if(status == GameStatus.FINISHED) {
            winner = player;
        }

        return status != GameStatus.IN_PROGRESS;
    }
}
