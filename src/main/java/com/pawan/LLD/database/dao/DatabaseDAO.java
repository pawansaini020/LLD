package com.pawan.LLD.database.dao;

import com.pawan.LLD.database.dto.DatabaseDTO;
import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * @author Pawan Saini
 * Created on 17/10/24.
 */
@Component
public class DatabaseDAO {

    private HashMap<String, DatabaseDTO> DATABASE;

    public DatabaseDAO() {
        DATABASE = new HashMap<>();
    }

    public void creatDatabase(DatabaseDTO database) {
        DATABASE.put(database.getName(), database);
    }
}
