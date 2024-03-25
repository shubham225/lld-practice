package com.practice.lld.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Random;

@Getter
@Setter
public class Bot extends Player {
    public Bot(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    @Override
    public Position play(Board board) {
        List<Cell> availableCells = board.getAvailableCells();
        Random random = new Random();
        int indx = random.nextInt();
        indx = Math.abs(indx);
        indx %= availableCells.size();
        Cell cell = availableCells.get(indx);
        return cell.getPosition();
    }
}
