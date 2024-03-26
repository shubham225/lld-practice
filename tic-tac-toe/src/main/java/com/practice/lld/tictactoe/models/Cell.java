package com.practice.lld.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int row;
    private int col;
    private CellStatus status;
    private Player player;

    public Cell(int row, int col) {
        this.row = row;
        this.col = col;
        this.status = CellStatus.AVAILABLE;
        this.player = null;
    }

    public String getSymbol() {
        return (player != null) ? player.getSymbol() : " ";
    }
}
