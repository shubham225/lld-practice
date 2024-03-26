package com.practice.lld.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

import java.util.Scanner;

@Getter
@Setter
public class Human extends Player {
    public Human() {}
    public Human(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    @Override
    public Move play(Board board) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter row : ");
        int row = in.nextInt();
        System.out.println("Enter col : ");
        int col = in.nextInt();
        return new Move(this, board.getCell(row, col));
    }
}
