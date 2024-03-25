package com.practice.lld.tictactoe.controllers;

import com.practice.lld.tictactoe.models.Board;
import com.practice.lld.tictactoe.models.Game;
import com.practice.lld.tictactoe.models.HumanPlayer;
import com.practice.lld.tictactoe.models.Player;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/V1/tictactoe")
public class GameController {

    @RequestMapping(
            method = RequestMethod.GET,
            path = "/play"
    )
    public Board getGameBoard() {
        Board board = new Board(2);
        List<Player> playerList = new ArrayList<>();
        Player player1 = new HumanPlayer("shubham", 'x');
        Player player2 = new HumanPlayer("shubham", 'x');
        playerList.add(player1);
        playerList.add(player2);

        Game game = new Game(board, playerList);

        return board;
    }
}
