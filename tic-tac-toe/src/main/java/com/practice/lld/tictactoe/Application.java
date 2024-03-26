package com.practice.lld.tictactoe;

import com.practice.lld.tictactoe.models.*;
import com.practice.lld.tictactoe.services.GameService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);

		List<Player> playerList = new ArrayList<>();
		boolean undoAllowed = getUserInput(playerList);
//		Player player1 = new Human("Shubham", "✖\uFE0F");
//		Player player2 = new Bot("Bot", "⭕");
//		playerList.add(player1);
//		playerList.add(player2);
		Game game = null;

		try {
			game = Game.builder()
					.setBoardSize(3)
					.setPlayers(playerList)
					.setUndoAllowed(undoAllowed)
					.build();
			game.start();
		}catch (RuntimeException e) {
			System.out.println(e.getMessage());
		}

//		GameService gameService = new GameService();
//		gameService.startGame();
	}

	public static boolean getUserInput(List<Player> players){
		Scanner in = new Scanner(System.in);
		boolean undoEnabled = false;
		boolean isBot = false;

		System.out.println("Do you want to allow undo the move? (Y/N)");
		char c = in.next().charAt(0);

		if(c == 'Y' || c == 'y') {
			undoEnabled = true;
		}

		System.out.println("How many players will play? :");
		int count = in.nextInt();

		for (int i = 1; i <= count; i++) {
			System.out.println("Name of Player-" + i + " :");
			String name = in.next();

			System.out.println("Symbol for Player-" + i + " :");
			String symbol = in.next();

			System.out.println("Is Player-" + i + " a bot? (Y/N)");
			char type = in.next().charAt(0);

			if(type == 'Y' || type == 'y') {
				isBot = true;
			}
			if (isBot) {
				players.add(new Bot(name, symbol));
			}else {
				players.add(new Human(name, symbol));
			}
		}
		return undoEnabled;
	}
}
