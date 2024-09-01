package com.pawan.LLD.lld.tictactoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Pawan Saini
 * Created on 01/09/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TPlayerDTO extends BaseDTO {

    private String name;
    private String mark;
}
