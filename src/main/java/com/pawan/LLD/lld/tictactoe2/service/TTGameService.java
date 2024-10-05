package com.pawan.LLD.lld.tictactoe2.service;

import com.pawan.LLD.lld.tictactoe2.dao.TTGameDao;
import com.pawan.LLD.lld.tictactoe2.dto.TTGame;
import com.pawan.LLD.lld.tictactoe2.manager.TTGameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @author Pawan Saini
 * Created on 05/10/24.
 */
@Slf4j
@Service
public class TTGameService {

    private final TTGameDao gameDao;
    private final TTGameManager gameManager;

    public TTGameService(TTGameDao gameDao,
                         TTGameManager gameManager) {
        this.gameDao = gameDao;
        this.gameManager = gameManager;
    }

    public TTGame initGame(int size, String players[], String moves[]) {
        TTGame game = new TTGame(size);
        game.init(players, moves);
        gameDao.save(game);
        return game;
    }

    public String play(Long gameId, int x, int y) {
        TTGame game = gameDao.get(gameId);
        int size = game.getBoard().getSize();
        gameManager.isValidMove(game, size, x, y);
        gameManager.addMove(game, size, x,  y);
        if(gameManager.isWinner(game, size)) {
            log.info("{}[{}] is winner of the game.", game.getWinner().getName(), game.getWinner().getMove());
            return String.format("%s[%s] is winner of the game.", game.getWinner().getName(), game.getWinner().getMove());
        }
        gameManager.changeTurn(game);
        log.info("{}[{}] has next turn for new move.", game.getPlayers()[game.getTurn()].getName(), game.getPlayers()[game.getTurn()].getMove());
        return String.format("%s[%s] has next turn for new move.", game.getPlayers()[game.getTurn()].getName(), game.getPlayers()[game.getTurn()].getMove());
    }

    public TTGame getGame(Long gameId) {
        return gameDao.get(gameId);
    }
}
