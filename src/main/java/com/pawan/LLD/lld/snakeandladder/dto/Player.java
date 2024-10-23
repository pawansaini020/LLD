package com.pawan.LLD.lld.snakeandladder.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Player {

    private String name;
    private int position;

    public Player(String name) {
        this.name = name;
        this.position = 0;
    }
}
