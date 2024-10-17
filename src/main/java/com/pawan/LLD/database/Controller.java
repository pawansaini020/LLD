package com.pawan.LLD.database;

import com.pawan.LLD.database.service.ConsoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pawan Saini
 * Created on 17/10/24.
 */
@Slf4j
@RestController
@RequestMapping("/database")
public class Controller {

    @Autowired
    private ConsoleService consoleService;

    @PostMapping("/create-table")
    public void createTable(@RequestParam("query") String query) {
        consoleService.executeQuery(query);
    }
}
