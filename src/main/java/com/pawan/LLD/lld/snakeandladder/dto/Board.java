package com.pawan.LLD.lld.snakeandladder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Pawan Saini
 * Created on 08/08/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Board {

    private int size;
    private List<Cell> cells;

    public Board(int size) {
        this.size = size;
        cells = new ArrayList<>();
    }

    public void initBoard() {
        for(int i=0; i<size+1; i++) {
            cells.add(new Cell());
        }
        log.info("Initialized a game of cells: {}", size);
        addSnakeAndLadder();
    }

    private void addSnakeAndLadder() {
        Set<Integer> snakeOrLadderPositions = new HashSet<>();
        for(int i=0;i<Math.sqrt(size);i++) {
            addSnake(snakeOrLadderPositions);
            addLadder(snakeOrLadderPositions);
        }
    }

    private void addLadder(Set<Integer> snakeOrLadderPositions) {
        Ladder ladder = new Ladder(size);
        while(!isValidSnakeOrLadder(ladder.getStartPosition(), ladder.getEndPosition(), snakeOrLadderPositions)) {
            ladder = new Ladder(size);
        }
        cells.get(ladder.getStartPosition()).setLadder(ladder);
        log.info("Assigned new ladder at postition: {}, {}", ladder.getStartPosition(), ladder.getEndPosition());
    }

    private void addSnake(Set<Integer> snakeOrLadderPositions) {
        Snake snake = new Snake(size);
        while(!isValidSnakeOrLadder(snake.getStartPosition(), snake.getEndPosition(), snakeOrLadderPositions)) {
            snake = new Snake(size);
        }
        cells.get(snake.getStartPosition()).setSnake(snake);
        log.info("Assigned new snake at postition: {}, {}", snake.getStartPosition(), snake.getEndPosition());
    }

    private boolean isValidSnakeOrLadder(int startPosition, int endPosition, Set<Integer> snakeOrLadderPositions) {
        Boolean isValid = !snakeOrLadderPositions.contains(startPosition) || !snakeOrLadderPositions.contains(endPosition);
        if(isValid) {
            snakeOrLadderPositions.add(startPosition);
            snakeOrLadderPositions.add(endPosition);
        }
        return isValid;
    }


}
