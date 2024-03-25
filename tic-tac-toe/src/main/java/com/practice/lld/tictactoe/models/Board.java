package com.practice.lld.tictactoe.models;

import java.util.ArrayList;
import java.util.List;

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
    public void printBoard() {
        for(int i = 0; i < cells.size(); i++) {
            for(int j = 0; j < cells.get(i).size(); j++) {
                Cell cell = cells.get(i).get(j);
                System.out.print("|" + cell.getSymbol() + "|");
            }
            System.out.println(" ");
        }
    }

    public Cell getCell(Position position) {
        Cell cell = cells.get(position.getRow()).get(position.getCol());
        return cell;
    }

    public boolean markPosition(Position position, Player player) {
        Cell cell = getCell(position);
        if(cell.getStatus() == CellStatus.AVAILABLE) {
            cell.setPosition(position);
            cell.setPlayer(player);
            cell.setStatus(CellStatus.MARKED);
            return true;
        }

        return false;
    }

    public GameStatus checkWin(Position position, Player player) {
        boolean allCellsFilled = true;
        boolean won = true;
        int x = position.getRow();
        int y = position.getCol();

        if(x == y || (x == cells.size()-1 && y == 0) || (x == 0 && y == cells.size()-1)) {
            //first diagonal
            won = true;
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
        for(int i = 0; i < cells.size(); i++) {
            char ch = cells.get(i).get(y).getSymbol();
            if(ch != player.getSymbol()) {
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


        for(int i = 0; i < cells.size(); i++) {
            for(int j = 0; j < cells.get(i).size(); j++) {
                Cell cell = cells.get(i).get(j);
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
}
