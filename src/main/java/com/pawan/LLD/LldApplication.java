package com.pawan.LLD;

import com.pawan.LLD.interview.Interview2;
import com.pawan.LLD.lld.snakeandladder.manager.GameManager;
import com.pawan.LLD.lld.snakeandladder.service.GameService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@SpringBootApplication
public class LldApplication {

	public static void main(String[] args) {
		SpringApplication.run(LldApplication.class, args);
//		GameService gameService = new GameService(new GameManager());
//		gameService.playGame(100, 6, Arrays.asList("Pawan", "Viman", "Sushil"));

//		Interview2 interview2 = new Interview2();
//		interview2.maxContinueSeq();
	}

}
