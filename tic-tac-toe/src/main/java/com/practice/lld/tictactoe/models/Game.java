package com.practice.lld.tictactoe.models;

import com.practice.lld.tictactoe.services.GameService;
import lombok.Getter;
import lombok.Setter;

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
    private GameService gameService;
    private boolean undoAllowed;

    private Game(Builder builder) {
        this.board = new Board(builder.boardSize);
        this.players = builder.players;
        this.undoAllowed = builder.undoAllowed;
        this.status = GameStatus.IN_PROGRESS;
        this.moves = new ArrayList<>();
        this.nextPlayerIndex = 0;
        this.winner = null;
        this.gameService = new GameService();
    }

    public static Builder builder() {
        return new Builder();
    }
    private Player getNextPlayer() {
        return players.get(nextPlayerIndex);
    }

    private void updateNextPlayer() {
        nextPlayerIndex = (nextPlayerIndex + 1) % (players.size());
    }

    public boolean isInProgress() {
        return (status == GameStatus.IN_PROGRESS);
    }

    public void playMove() {
        Player player = getNextPlayer();
        Move move = player.decideAndPlayMove(board);
        moves.add(move);
        refreshGameStatus();
        updateNextPlayer();
    }

    public void start(){
        gameService.startGame(this);
    }

    public void printGame() {
        System.out.println(" ");
        System.out.println("-------------");
        System.out.println("'" + getNextPlayer().getName() + "'s' Turn");
        System.out.println("-------------");
        board.printBoard();
        System.out.println(" ");
    }

    public Move getLastMove() {
        return moves.get(moves.size()-1);
    }

    public Player getCurrentPlayer() {
        return players.get(nextPlayerIndex);
    }

    private void refreshGameStatus() {
        gameService.refreshGameStatus(this);
    }

    private void undoLastMove() {
        if(!moves.isEmpty()) {
            Move move = moves.remove(moves.size()-1);
            board.undoMove(move);
        }
    }

    public void askUndo() {
        if (!undoAllowed)
            return;

        Move move = getLastMove();

        if (move.getPlayer() instanceof Bot)
            return;

        board.printBoard();
        System.out.println("Do you want to undo the move? (Y/N)");
        Scanner in = new Scanner(System.in);
        char c = in.next().charAt(0);

        if(c == 'Y' || c == 'y') {
            undoLastMove();

            if (nextPlayerIndex == 0)
                nextPlayerIndex = players.size() - 1;
            else
                nextPlayerIndex--;
        }
    }

    public static class Builder {
        private int boardSize;
        private List<Player> players;
        private boolean undoAllowed;

        public Builder setBoardSize(int boardSize) {
            this.boardSize = boardSize;
            return this;
        }

        public Builder setPlayers(List<Player> players) {
            this.players = players;
            return this;
        }

        public Builder setUndoAllowed(Boolean undoAllowed) {
            this.undoAllowed = undoAllowed;
            return this;
        }

        public Game build() {
            if(boardSize < 3)
                throw new RuntimeException("Board Size should be greater than 3.");

            if(players.size() < 2)
                throw new RuntimeException("Game requires at least 2 players.");

            if(!undoAllowed)
                undoAllowed = false;

            return new Game(this);
        }
    }
}
