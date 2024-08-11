package com.pawan.LLD.lld.snakeandladder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * @author Pawan Saini
 * Created on 08/08/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Ladder {

    private int startPosition;
    private int endPosition;

    public Ladder(int boardSize) {
        this.startPosition = new Random().nextInt(1, boardSize-1);
        this.endPosition = new Random().nextInt(1, boardSize);
        while(startPosition >= endPosition) {
            this.endPosition = new Random().nextInt(1, boardSize);
        }
    }
}
