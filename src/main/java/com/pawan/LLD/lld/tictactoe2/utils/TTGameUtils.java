package com.pawan.LLD.lld.tictactoe2.utils;

import com.pawan.LLD.lld.tictactoe2.dto.TTBoard;
import com.pawan.LLD.lld.tictactoe2.dto.TTGame;
import org.apache.commons.lang3.StringUtils;

/**
 * @author Pawan Saini
 * Created on 05/10/24.
 */
public class TTGameUtils {

    public static void printGameState(TTGame game, int size) {
        System.out.println("Current Game state: ");
        TTBoard board = game.getBoard();
        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(StringUtils.isNotBlank(board.getCells()[i][j].getMove())) {
                    System.out.print(board.getCells()[i][j].getMove() + " ");
                } else {
                    System.out.print("_ ");
                }
            }
            System.out.println();
        }
    }
}
