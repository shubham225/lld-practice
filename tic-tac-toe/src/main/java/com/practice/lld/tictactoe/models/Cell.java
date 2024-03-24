package com.practice.lld.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Cell {
    private int col;
    private int row;
    private CellStatus status;
    private Player player;

    public char getCellSymbol() {
        return player.getSymbol();
    }
}
