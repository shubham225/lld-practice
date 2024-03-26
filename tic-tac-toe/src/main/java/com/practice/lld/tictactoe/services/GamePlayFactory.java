package com.practice.lld.tictactoe.services;

import com.practice.lld.tictactoe.models.PlayerType;
import com.practice.lld.tictactoe.services.strategies.BotEasyGamePlay;
import com.practice.lld.tictactoe.services.strategies.HumanGamePlay;
import org.springframework.stereotype.Service;

@Service
public class GamePlayFactory {
    public static GamePlayStategy getGamePlayStrategy(PlayerType playerType) {
        switch (playerType) {
            case HUMAN -> {
                return new HumanGamePlay();
            }
            case BOT_EASY -> {
                return new BotEasyGamePlay();
            }
            // TODO : Implementation
//            case BOT_MEDIUM -> {
//            }
//            case BOT_HARD -> {
//            }
        }

        return new HumanGamePlay();
    }
}
