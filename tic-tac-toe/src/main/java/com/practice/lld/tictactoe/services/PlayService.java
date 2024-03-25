package com.practice.lld.tictactoe.services;

import com.practice.lld.tictactoe.models.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayService {
    public boolean play(int row, int col) {
        return true;
    }

    public GameStatus checkWin(Board board, Position position, Player player) {
        // TODO: Modify the logic for identification of winner
        boolean allCellsFilled = true;
        boolean won = true;
        int x = position.getRow();
        int y = position.getCol();
        List<List<Cell>> cells = board.getCells();

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
