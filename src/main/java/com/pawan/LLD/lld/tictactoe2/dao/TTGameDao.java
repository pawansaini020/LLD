package com.pawan.LLD.lld.tictactoe2.dao;

import com.pawan.LLD.lld.tictactoe2.dto.TTGame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Pawan Saini
 * Created on 05/10/24.
 */
@Slf4j
@Service
public class TTGameDao {

    private ConcurrentHashMap<Long, TTGame> GAME_DATA = new ConcurrentHashMap<>();

    public TTGame save(TTGame game) {
        Long id = new Random().nextLong(1, 1000);
        while(GAME_DATA.containsKey(id)) {
            id = new Random().nextLong(1, 1000);
        }
        game.setId(id);
        GAME_DATA.put(id, game);
        return game;
    }

    public TTGame get(Long id) {
        if(!GAME_DATA.containsKey(id)) {
            throw new RuntimeException("Game id doesn't exist in the system : " + id);
        }
        return GAME_DATA.get(id);
    }
}
