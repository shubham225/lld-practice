package com.practice.lld.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Board {
    private List<List<Cell>> cells;

    public Board(int size) {
        this.cells = new ArrayList<>();

        for(int i = 0; i < size; i++) {
            this.cells.add(new ArrayList<>());
            for(int j = 0; j < size; j++) {
                Cell cell = new Cell(i, j);
                this.cells.get(i).add(cell);
            }
        }
    }

    public List<Cell> getAvailableCells() {
        List<Cell> availableCells = new ArrayList<>();

        for (List<Cell> list : this.cells) {
            for (Cell cell : list) {
                if (cell.getStatus() == CellStatus.AVAILABLE)
                    availableCells.add(cell);
            }
        }
        return availableCells;
    }

    public void printBoard() {
        for (List<Cell> list : cells) {
            for (Cell cell : list) {
                System.out.print("|" + cell.getSymbol() + "|");
            }
            System.out.println(" ");
        }
    }

    public Cell getCell(int row, int col) {
        return cells.get(row).get(col);
    }

    public boolean makeMove(Move move) {
        Cell cell = move.getCell();

        if(cell.getStatus() == CellStatus.AVAILABLE) {
            cell.setPlayer(move.getPlayer());
            cell.setStatus(CellStatus.MARKED);
            return true;
        }

        return false;
    }

    public void undoMove(Move move) {
        Cell cell = move.getCell();
        cell.setPlayer(null);
        cell.setStatus(CellStatus.AVAILABLE);
    }
}
