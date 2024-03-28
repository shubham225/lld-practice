package com.practice.lld.tictactoe.services;

import com.practice.lld.tictactoe.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

public class GameService {
    public void startGame(Game game) {
        while(game.isInProgress()) {
            try {
                game.printGame();
                game.playMove();
                if(game.isInProgress())
                    game.askUndo();
            }catch (RuntimeException e) {
                System.out.println(e.getMessage());
            }
        }

        if(game.getStatus() == GameStatus.FINISHED) {
            System.out.println(" ");
            System.out.println("=============================");
            game.getBoard().printBoard();
            System.out.println("-----------------------------");
            System.out.println("'" + game.getWinner().getName() + "' Won!!!\uD83E\uDD73");
            System.out.println("-----------------------------");
            System.out.println("=============================");
        }else {
            System.out.println("It's a draw\uD83E\uDEE4");
        }
    }

    public void refreshGameStatus(Game game) {
        boolean allCellsFilled = true;
        boolean won = true;
        Move move = game.getLastMove();
        Player player = game.getCurrentPlayer();

        List<List<Cell>> cells = game.getBoard().getCells();
        int x = move.getCell().getRow();
        int y = move.getCell().getCol();

        if(x == y || (x == cells.size()-1 && y == 0) || (x == 0 && y == cells.size()-1)) {
            //first diagonal
            int a = 0;
            int b = 0;
            for(int i = 0; i < cells.size(); i++) {
                String ch = cells.get(a).get(b).getSymbol();
                if (!player.isSymbolEquals(ch)) {
                    won = false;
                    break;
                }
                a++;
                b++;
            }

            if(won) {
                game.setWinner(player);
                game.setStatus(GameStatus.FINISHED);
                return;
            }

            //second diagonal
            won = true;
            a = 0;
            b = 2;
            for(int i = 0; i < cells.size(); i++) {
                String ch = cells.get(Math.abs(a)).get(Math.abs(b)).getSymbol();
                if(!player.isSymbolEquals(ch)) {
                    won = false;
                    break;
                }
                a--;
                b--;
            }

            if(won) {
                game.setWinner(player);
                game.setStatus(GameStatus.FINISHED);
                return;
            }
        }

        won = true;
        for (List<Cell> cellList : cells) {
            String ch = cellList.get(y).getSymbol();
            if (!player.isSymbolEquals(ch)) {
                won = false;
                break;
            }
        }

        if(won) {
            game.setWinner(player);
            game.setStatus(GameStatus.FINISHED);
            return;
        }

        won = true;
        for(int i = 0; i < cells.get(x).size(); i++) {
            String ch = cells.get(x).get(i).getSymbol();
            if(!player.isSymbolEquals(ch)) {
                won = false;
                break;
            }
        }

        if(won) {
            game.setWinner(player);
            game.setStatus(GameStatus.FINISHED);
            return;
        }

        for (List<Cell> list : cells) {
            for (Cell cell : list) {
                if (cell.getPlayer() == null) {
                    allCellsFilled = false;
                    break;
                }
            }
        }

        if(allCellsFilled && !won) {
            game.setStatus(GameStatus.DRAW);
        }
        else if(won) {
            game.setWinner(player);
            game.setStatus(GameStatus.FINISHED);
        }
    }
}
