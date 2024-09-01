package com.pawan.LLD.lld.tictactoe.controller;

import com.pawan.LLD.lld.tictactoe.service.TGameService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Pawan Saini
 * Created on 01/09/24.
 */
@Slf4j
@RestController
@RequestMapping(value = "/tic-tac-toe/api/va/game")
public class GameController {

    private final TGameService gameService;

    @Autowired
    public GameController(TGameService gameService) {
        this.gameService = gameService;
    }

    @PostMapping(value = "/init")
    public ResponseEntity<?> intiGame(@RequestParam(value = "size") Integer size,
                                      @RequestParam(value = "players") String players[]) {
        return new ResponseEntity<>(gameService.initGame(size, players), HttpStatus.OK);
    }

    @PostMapping(value = "/play")
    public ResponseEntity<?> playGame(@RequestParam(value = "move") Integer move,
                                      @RequestParam(value = "game_id") Long gameId) {
        return new ResponseEntity<>(gameService.playGame(move, gameId), HttpStatus.OK);
    }

    @GetMapping(value = "/get")
    public ResponseEntity<?> playGame(@RequestParam(value = "game_id") Long gameId) {
        return new ResponseEntity<>(gameService.getGame(gameId), HttpStatus.OK);
    }
}
