package com.pawan.LLD.lld.snakeandladder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Snake {

    private int startPosition;
    private int endPosition;

    public Snake(int boardSize) {
        this.startPosition = new Random().nextInt(1, boardSize);
        this.endPosition = new Random().nextInt(1, boardSize);
        while(startPosition <= endPosition) {
            this.endPosition = new Random().nextInt(1, boardSize);
        }
    }
}
