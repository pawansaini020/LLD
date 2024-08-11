package com.pawan.LLD.lld.snakeandladder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Random;

/**
 * @author Pawan Saini
 * Created on 11/08/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dice {

    private int diceSide;

    public int roll() {
        return new Random().nextInt(1, diceSide);
    }
}
