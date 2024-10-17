package com.pawan.LLD.database.service;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pawan Saini
 * Created on 17/10/24.
 */
@Slf4j
@Service
public class ConsoleService {

    private final TableService tableService;

    @Autowired
    private ConsoleService(TableService tableService) {
        this.tableService = tableService;
    }

    public void executeQuery(String query) {
        if(StringUtils.isBlank(query)) {
            throw new RuntimeException("Query Not Supported");
        }

        if(query.startsWith("CREATE Table")) {
            tableService.createTable(query);
        } if(query.startsWith("DELETE")) {
            tableService.deleteTable(query);
        }
    }
}
