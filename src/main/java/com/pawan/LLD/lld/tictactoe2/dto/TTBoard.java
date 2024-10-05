package com.pawan.LLD.lld.tictactoe2.dto;

import com.pawan.LLD.lld.tictactoe2.dto.base.BaseDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pawan Saini
 * Created on 05/10/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class TTBoard extends BaseDTO {

    private int size;
    private TTCell[][] cells;

    public TTBoard(int size) {
        this.size = size;
        this.cells = new TTCell[size][size];
    }

    public void init() {
        for(int i=0; i<this.size; i++) {
            for(int j=0; j<this.size; j++) {
                this.cells[i][j] = new TTCell();
            }
        }
    }
}
