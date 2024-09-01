package com.pawan.LLD.lld.tictactoe.service;

import com.pawan.LLD.lld.tictactoe.dao.TGameDao;
import com.pawan.LLD.lld.tictactoe.dto.TGameDTO;
import com.pawan.LLD.lld.tictactoe.exceptions.TGameException;
import com.pawan.LLD.lld.tictactoe.manager.TGameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Pawan Saini
 * Created on 01/09/24.
 */
@Slf4j
@Service
public class TGameService {

    private final TGameDao gameDao;
    private final TGameManager gameManager;

    @Autowired
    private TGameService(TGameDao gameDao,
                         TGameManager gameManager) {
        this.gameDao = gameDao;
        this.gameManager = gameManager;
    }

    public TGameDTO initGame(int size, String players[]) {
        if(size%3 != 0 || players.length != 2) {
            throw  new TGameException("Give board side multiple of 3 and 2 player name.");
        }
        TGameDTO game = new TGameDTO();
        game.init(size, players);
        gameDao.add(game);
        return game;
    }

    public String playGame(int move, Long id) {
        TGameDTO game = gameDao.getById(id);
        gameManager.validateGame(move, game);
        gameManager.playGameWithMove(game, move);
        if(gameManager.checkWinner(game)) {
            game.setWinner(game.getPlayers().get(game.getTurn()));
            log.info("Player: {} won the game: {}, among: {}", game.getWinner(), game.getId(), game.getPlayers());
            return String.format("Player: %s won the game.", game.getWinner().getName());
        }
        if(gameManager.checkDraw(game)) {
            log.info("Game: {} is draw among: {}", game.getId(), game.getPlayers());
            return String.format("Game: {} is draw among: {}", game.getId(), game.getPlayers().toString());
        }
        return gameManager.updateTurn(game);
    }

    public TGameDTO getGame(Long gameId) {
        return gameDao.getById(gameId);
    }
}
