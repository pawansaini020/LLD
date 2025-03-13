package com.pawan.LLD;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
public class Table {

    private String name;
    private List<Column> column;
    private Map<Integer, Row> rows;
}
