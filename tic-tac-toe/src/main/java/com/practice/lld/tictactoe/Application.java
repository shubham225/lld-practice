package com.practice.lld.tictactoe;

import com.practice.lld.tictactoe.models.Game;
import com.practice.lld.tictactoe.services.GameService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

	public static void main(String[] args) {
		//SpringApplication.run(Application.class, args);
		GameService gameService = new GameService();
		gameService.startGame();
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Hello World!!!!");
	}
}
