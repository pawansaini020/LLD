package com.pawan.LLD.lld.tictactoe.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Random;

/**
 * @author Pawan Saini
 * Created on 01/09/24.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class BaseDTO {

    private Long id = new Random().nextLong(0, Long.MAX_VALUE);
    private Date createdAt = new Date();
}
