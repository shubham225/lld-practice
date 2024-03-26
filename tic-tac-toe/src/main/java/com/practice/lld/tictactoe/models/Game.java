package com.practice.lld.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import javax.script.ScriptContext;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

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

    public Move getLastMove() {
        return moves.get(moves.size()-1);
    }

    public Player getCurrentPlayer() {
        return players.get(nextPlayerIndex);
    }

    public boolean checkGameEnd(Move move, Player player) {
        status = board.checkWin(move, player);
        if(status == GameStatus.FINISHED) {
            winner = player;
        }

        return status != GameStatus.IN_PROGRESS;
    }

    public void undo() {
        if(!moves.isEmpty()) {
            Move move = moves.remove(moves.size()-1);
            board.undoMove(move);
        }
    }

    public void askUndo() {
        if (getCurrentPlayer() instanceof Bot)
            return;

        board.printBoard();
        System.out.println("Do you want to undo the move?(Y/N)");
        Scanner in = new Scanner(System.in);
        char c = in.next().charAt(0);

        if(c == 'Y' || c == 'y') {
            undo();
            if (nextPlayerIndex == 0)
                nextPlayerIndex = players.size() - 1;
            else
                nextPlayerIndex--;
        }
    }
}
