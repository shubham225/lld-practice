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

    public GameStatus checkWin(Move move, Player player) {
        boolean allCellsFilled = true;
        boolean won = true;
        int x = move.getCell().getRow();
        int y = move.getCell().getCol();

        if(x == y || (x == cells.size()-1 && y == 0) || (x == 0 && y == cells.size()-1)) {
            //first diagonal
            int a = 0;
            int b = 0;
            for(int i = 0; i < cells.size(); i++) {
                char ch = cells.get(a).get(b).getSymbol();
                if (ch != player.getSymbol()) {
                    won = false;
                    break;
                }
                a++;
                b++;
            }
            if(won) return GameStatus.FINISHED;

            //second diagonal
            won = true;
            a = 0;
            b = 2;
            for(int i = 0; i < cells.size(); i++) {
                char ch = cells.get(Math.abs(a)).get(Math.abs(b)).getSymbol();
                if(ch != player.getSymbol()) {
                    won = false;
                    break;
                }
                a--;
                b--;
            }
            if(won) return GameStatus.FINISHED;
        }

        won = true;
        for (List<Cell> cellList : cells) {
            char ch = cellList.get(y).getSymbol();
            if (ch != player.getSymbol()) {
                won = false;
                break;
            }
        }

        if(won) return GameStatus.FINISHED;

        won = true;
        for(int i = 0; i < cells.get(x).size(); i++) {
            char ch = cells.get(x).get(i).getSymbol();
            if(ch != player.getSymbol()) {
                won = false;
                break;
            }
        }

        if(won) return GameStatus.FINISHED;


        for (List<Cell> list : cells) {
            for (Cell cell : list) {
                if (cell.getPlayer() == null) {
                    allCellsFilled = false;
                    break;
                }
            }
        }

        if(allCellsFilled && !won)
            return GameStatus.DRAW;
        else
            return (won) ? GameStatus.FINISHED : GameStatus.IN_PROGRESS;
    }

    public void undoMove(Move move) {
        Cell cell = move.getCell();
        cell.setPlayer(null);
        cell.setStatus(CellStatus.AVAILABLE);
    }
}
