package com.pawan.LLD;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StorageStorage {

    Map<String, Table> TABLES;

    public StorageStorage(){
        TABLES = new HashMap<>();
    }

    public Boolean createTable(String name, List<Column> columns) {
        if(TABLES.containsKey(name)) {
            return false;
        }
        Table table = new Table(name, columns, new HashMap<>());
        TABLES.put(name, table);
        return true;
    }

    public void insertRow(String tableName, Row row) {
        Table table = TABLES.get(tableName);
        if(table!=null) {
            int key = (int) row.getData().get(table.getColumn().get(0).getName());
            table.getRows().put(key, row);
        }
    }

    public List<Row> getRows(String tableName) {
        Table table = TABLES.get(tableName);
        if(table!=null) {
            return new ArrayList<>(table.getRows().values());
        }
        return new ArrayList<>();
    }
}
