package com.practice.lld.tictactoe.models;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Move {
    private Player player;
    private Cell cell;

    private Move(Builder builder) {
        this.player = builder.player;
        this.cell = builder.cell;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private Player player;
        private Cell cell;

        public Builder setPlayer(Player player) {
            this.player = player;
            return this;
        }

        public Builder setCell(Cell cell) {
            this.cell = cell;
            return this;
        }

        public Move build() {
            if (this.player == null)
                throw new RuntimeException("Player Invalid");

            if (this.cell == null || this.cell.getStatus() != CellStatus.AVAILABLE)
                throw new RuntimeException("Invalid Move, Choose again.");

            return new Move(this);
        }
    }

}
