package com.practice.lld.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private Position position;
    private CellStatus status;
    private Player player;

    public Cell(int row, int col) {
        this.position = new Position(row, col);
        this.status = CellStatus.AVAILABLE;
        this.player = null;
    }

    public Cell(Position position, CellStatus status, Player player) {
        this.position = position;
        this.status = status;
        this.player = player;
    }

    public char getSymbol() {
        return (player != null) ? player.getSymbol() : ' ';
    }
}
