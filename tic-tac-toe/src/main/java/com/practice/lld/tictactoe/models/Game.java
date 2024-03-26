package com.practice.lld.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Game {
    private Board board;
    private List<Player> players;
    private List<Move> moves;
    private Player winner;
    private int nextPlayerIndex;
    private GameStatus status;

    public Game() {
        this.board = null;
        this.players = new ArrayList<>();
        this.status = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.winner = null;
    }

    public Game(Board board, List<Player> players) {
        this.board = board;
        this.players = players;
        this.status = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.winner = null;
    }

    public Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    public void updateNextPlayer() {
        nextPlayerIndex = (nextPlayerIndex + 1) % (players.size());
    }

    public boolean gameIsInProgress() {
        return (status == GameStatus.IN_PROGRESS);
    }

    public boolean play() {
        Player player = getNextPlayer();
        Move move = player.play(board);

        if (board.makeMove(move)) {
            moves.add(move);
            return true;
        }

        return false;
    }

    public void printGame() {
        System.out.println("'" + getNextPlayer().getName() + "'s' Turn");
        board.printBoard();
    }

    public boolean checkGameEnd(Move move, Player player) {
        // TODO: Update Code
        status = board.checkWin(move, player);
        if(status == GameStatus.FINISHED) {
            winner = player;
        }

        return status != GameStatus.IN_PROGRESS;
    }
}
