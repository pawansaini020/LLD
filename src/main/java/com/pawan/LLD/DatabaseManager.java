package com.pawan.LLD;


import java.util.List;

public class DatabaseManager {

    public static final void main(String[] args) {
        StorageStorage storage = new StorageStorage();

        List<Column> columns = List.of(
                new Column("id", DataType.BIG_INT, true, true),
                new Column("name", DataType.VAR_CHAR, false, false),
                new Column("email", DataType.VAR_CHAR, false, false),
                new Column("phone", DataType.VAR_CHAR, false, false)
        );

        storage.createTable("users", columns);

        Row row = new Row();
        row.getData().put("id", 1);
        row.getData().put("name", "Pawan");
        row.getData().put("email", "xyz");
        row.getData().put("phone", "1234567890");

        storage.insertRow("users", row);

        Row row1 = new Row();
        row1.getData().put("id", 2);
        row1.getData().put("name", "Saini");
        row1.getData().put("email", "saini@gmail.com");
        row1.getData().put("phone", "0987654321");

        storage.insertRow("users", row1);

        List<Row> rows = storage.getRows("users");

        for(Row r : rows) {
            System.out.println("id: " + r.getData().get("id") + " name: " + r.getData().get("name") + " email: " + r.getData().get("email") +" phone: " + r.getData().get("phone"));
        }
    }
}
