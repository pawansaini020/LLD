package com.pawan.LLD.lld.tictactoe.dao;

import com.pawan.LLD.lld.tictactoe.dto.TGameDTO;
import com.pawan.LLD.lld.tictactoe.exceptions.TGameException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Pawan Saini
 * Created on 01/09/24.
 */
@Component
@Slf4j
public class TGameDao {

    private ConcurrentHashMap<Long, TGameDTO> GAMES = new ConcurrentHashMap<>();

    public void add(TGameDTO game) {
        GAMES.put(game.getId(), game);
        log.info("Initialized a new tic tac toe game with id: {} of size: {} with players: {}", game.getId(),  game.getBoard().getSize(), game.getPlayers());
    }

    public TGameDTO getById(Long id) {
        if(!GAMES.containsKey(id)) {
            throw new TGameException("Game not exist with id: " + id);
        }
        return GAMES.get(id);
    }

    public void save(TGameDTO game) {
        GAMES.put(game.getId(), game);
    }
}
