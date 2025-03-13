package com.pawan.LLD;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Row {
    Map<String, Object> data;

    public Row() {
        data = new HashMap<>();
    }
}
