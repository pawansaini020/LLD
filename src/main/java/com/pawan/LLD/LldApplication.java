package com.pawan.LLD;

import com.pawan.LLD.interview.Interview2;
import com.pawan.LLD.interview.Test1;
import com.pawan.LLD.interview.Test3;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class LldApplication {

	public static void main(String[] args) {
		SpringApplication.run(LldApplication.class, args);
//		GameService gameService = new GameService(new GameManager());
//		gameService.playGame(100, 6, Arrays.asList("Pawan", "Viman", "Sushil"));

//		Interview2 interview2 = new Interview2();
//		interview2.maxContinueSeq();

//		new Test1().columnName(676);
//		int input[][] = {{1,3},{2,6},{8,10},{15,18}};
//		int res[][] = new Test1().mergeOverLapping(input);
//		System.out.println(res);

		String string = "catsandog";
		List list = new ArrayList<>(Arrays.asList("cats","dog","sand","and","cat"));
		Boolean valid = new Test3().isPartitionPossible(string, list);
		System.out.println(valid);
	}

}
