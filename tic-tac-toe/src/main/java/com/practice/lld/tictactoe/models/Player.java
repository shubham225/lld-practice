package com.practice.lld.tictactoe.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public abstract class Player {
    protected String name;
    protected String symbol;

    public abstract Move decideAndPlayMove(Board board);
    public boolean isSymbolEquals(String symbol) {
        return this.symbol.equals(symbol);
    }
}
