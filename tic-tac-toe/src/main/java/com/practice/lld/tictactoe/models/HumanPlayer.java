package com.practice.lld.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.Scanner;

@Getter
@Setter
public class HumanPlayer extends Player {
    public HumanPlayer() {}
    public HumanPlayer(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
    }
    @Override
    public Position play(Board board) {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter row : ");
        int row = in.nextInt();
        System.out.println("Enter col : ");
        int col = in.nextInt();
        return new Position(row, col);
    }
}
