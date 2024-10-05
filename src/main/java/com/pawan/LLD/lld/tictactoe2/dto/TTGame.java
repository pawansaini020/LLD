package com.pawan.LLD.lld.tictactoe2.dto;

import com.pawan.LLD.lld.tictactoe2.dto.base.BaseDTO;
import com.pawan.LLD.lld.tictactoe2.utils.TTGameUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

/**
 * @author Pawan Saini
 * Created on 05/10/24.
 */
@Data
@Slf4j
@AllArgsConstructor
@NoArgsConstructor
public class TTGame extends BaseDTO {

    private TTBoard board;
    private TTPlayer[] players;
    private int turn;
    private TTPlayer winner;

    public TTGame(int size) {
        this.board = new TTBoard(size);
        this.turn = 0;
    }

    public void init(String players[], String moves[]) {
        this.board.init();
        this.players = new TTPlayer[players.length];
        for(int i=0; i< players.length; i++) {
            this.players[i] = new TTPlayer(players[i], moves[i]);
        }
        log.info("Tic tac toe game is created with size: {}, players: {}", this.board.getSize(), this.players);
        TTGameUtils.printGameState(this, this.board.getSize());
    }
}
