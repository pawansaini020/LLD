package com.pawan.LLD.lld.tictactoe.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @author Pawan Saini
 * Created on 01/09/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(allowGetters = true)
@JsonInclude(JsonInclude.Include.NON_NULL)
@Slf4j
public class TGameDTO extends BaseDTO {

    private TBoardDTO board;
    private List<TPlayerDTO> players = new ArrayList<>();
    private int turn;
    private TPlayerDTO winner;

    public void init(int size, String players[]) {
        this.setId(new Random().nextLong(0, Long.MAX_VALUE));
        this.board = new TBoardDTO(size);
        this.players.add(new TPlayerDTO(players[0], "O"));
        this.players.add(new TPlayerDTO(players[1], "X"));
        this.turn = 0;
    }
}
