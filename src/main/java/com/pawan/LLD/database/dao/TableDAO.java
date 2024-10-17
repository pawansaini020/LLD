package com.pawan.LLD.database.dao;

import com.pawan.LLD.database.dto.TableDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author Pawan Saini
 * Created on 17/10/24.
 */
@Slf4j
@Component
public class TableDAO {

    private HashMap<String, TableDTO> TABLES;

    public TableDAO() {
        TABLES = new HashMap<>();
    }

    public void creatTable(TableDTO table) {
        TABLES.put(table.getName(), table);
        log.info("Table created successfully with schema: {}", table);
    }

    public void updateTable(TableDTO table) {
        TABLES.put(table.getName(), table);
        log.info("Table update successfully with schema: {}", table);
    }

    public void deleteTable(String tableName) {
        TABLES.remove(tableName);
        log.info("Table {} deleted successfully", tableName);
    }
}
