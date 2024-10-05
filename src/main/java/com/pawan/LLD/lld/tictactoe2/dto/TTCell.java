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
public class TTCell extends BaseDTO {

    private String move;
}
