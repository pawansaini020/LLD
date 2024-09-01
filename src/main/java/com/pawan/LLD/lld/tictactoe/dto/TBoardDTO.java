package com.pawan.LLD.lld.tictactoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pawan Saini
 * Created on 01/09/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TBoardDTO {

    private int size;
    private TCellDTO[][] cells;

    public TBoardDTO(int size) {
        this.size = size;
        this.cells = new TCellDTO[size][size];
        for(int i=0;i<size;i++) {
            for(int j=0;j<size;j++) {
                this.cells[i][j] = new TCellDTO();
            }
        }
    }
}
