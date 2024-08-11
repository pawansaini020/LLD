package com.pawan.LLD.lld.snakeandladder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pawan Saini
 * Created on 08/08/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cell {

    private Snake snake;
    private Ladder ladder;
}
