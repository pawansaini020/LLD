package com.pawan.LLD.lld.tictactoe2.controller;

import com.pawan.LLD.lld.tictactoe2.service.TTGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pawan Saini
 * Created on 05/10/24.
 */
@Slf4j
@RestController
@RequestMapping("/tictactoe2/api/v1/")
public class TTGameController {

    private final TTGameService gameService;

    @Autowired
    public TTGameController(TTGameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping("/init")
    public ResponseEntity<?> initGame(@RequestParam(value = "size") Integer size,
                                      @RequestParam(value = "players") String[] players,
                                      @RequestParam(value = "moves") String[] moves) {
        return new ResponseEntity<>(gameService.initGame(size, players, moves), HttpStatus.OK);
    }

    @PostMapping("/play")
    public ResponseEntity<?> playGame(@RequestParam(value = "id") Long id,
                                      @RequestParam(value = "x") int x,
                                      @RequestParam(value = "y") int y) {
        return new ResponseEntity<>(gameService.play(id, x, y), HttpStatus.OK);
    }

    @PostMapping("/get")
    public ResponseEntity<?> playGame(@RequestParam(value = "id") Long id) {
        return new ResponseEntity<>(gameService.getGame(id), HttpStatus.OK);
    }
}
