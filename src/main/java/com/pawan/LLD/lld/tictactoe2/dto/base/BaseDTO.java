package com.pawan.LLD.lld.tictactoe2.dto.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.Random;

/**
 * @author Pawan Saini
 * Created on 05/10/24.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BaseDTO {

    private Long id = new Random().nextLong(0, 1000);
    private Date createdAt = new Date();
}
