package com.pawan.LLD.database.service;

import com.pawan.LLD.database.dao.DatabaseDAO;
import com.pawan.LLD.database.dto.DatabaseDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @author Pawan Saini
 * Created on 17/10/24.
 */
@Slf4j
@Service
public class DatabaseService {

    private final DatabaseDAO databaseDAO;

    @Autowired
    public DatabaseService(DatabaseDAO databaseDAO) {
        this.databaseDAO = databaseDAO;
    }

    public void createDatabase(String name) {
        DatabaseDTO database = new DatabaseDTO(name, new ArrayList<>());
        databaseDAO.creatDatabase(database);
    }
}
