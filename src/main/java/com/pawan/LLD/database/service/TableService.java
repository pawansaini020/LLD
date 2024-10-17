package com.pawan.LLD.database.service;

import com.pawan.LLD.database.dao.DatabaseDAO;
import com.pawan.LLD.database.dao.TableDAO;
import com.pawan.LLD.database.dto.ColumnDTO;
import com.pawan.LLD.database.dto.SchemaDTO;
import com.pawan.LLD.database.dto.TableDTO;
import com.pawan.LLD.database.utils.QueryParser;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pawan Saini
 * Created on 17/10/24.
 */
@Slf4j
@Service
public class TableService {

    private TableDAO tableDAO;

    @Autowired
    public TableService(TableDAO tableDAO) {
        this.tableDAO = tableDAO;
    }

    public void createTable(String query) {

        TableDTO table = QueryParser.parseCreateTableQuery(query);
        tableDAO.creatTable(table);
    }

    public void updateTable(String query) {

    }

    public void deleteTable(String tableName) {
        tableDAO.deleteTable(tableName);
    }
}
