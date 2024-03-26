package com.practice.lld.tictactoe.services;

import com.practice.lld.tictactoe.models.Board;
import com.practice.lld.tictactoe.models.Move;
import com.practice.lld.tictactoe.models.Player;

public interface GamePlayStategy {
    public Move play(Board board, Player player);
}
