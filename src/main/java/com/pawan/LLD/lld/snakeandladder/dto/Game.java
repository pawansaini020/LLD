package com.pawan.LLD.lld.snakeandladder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Pawan Saini
 * Created on 11/08/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Slf4j
public class Game {

    private Board board;
    private Dice dice;
    private List<Player> players = new ArrayList<>();

    public void init(int size, int diceSide, List<String> playersName) {
        this.board = new Board(size);
        this.board.initBoard();
        this.dice = new Dice(diceSide);
        log.info("Added a dice of size: {} in the game.", diceSide);
        for(int i=0;i<playersName.size();i++) {
            this.players.add(new Player(playersName.get(i)));
            log.info("Added Player: {} in the game.", playersName.get(i));
        }
    }
}
