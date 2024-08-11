package com.pawan.LLD.lld.snakeandladder.service;

import com.pawan.LLD.lld.snakeandladder.dto.Game;
import com.pawan.LLD.lld.snakeandladder.dto.Player;
import com.pawan.LLD.lld.snakeandladder.manager.GameManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Pawan Saini
 * Created on 11/08/24.
 */
@Slf4j
@Service
public class GameService {

    private final GameManager gameManager;

    @Autowired
    public GameService(GameManager gameManager) {
        this.gameManager = gameManager;
    }

    public Player playGame(int size, int diceSide, List<String> playersName)  {
        Game game = new Game();
        game.init(size, diceSide, playersName);
        return startGame(game);
    }

    private Player startGame(Game game) {
        // start the game in loop till winner;
        Player winner = null;
        while(winner == null) {
            for(Player player : game.getPlayers()) {
                gameManager.playGameForPlayer(game, player);
                if(gameManager.isWinner(game, player)) {
                    log.info("Winner for this game is: {}", player.getName());
                    winner = player;
                    return winner;
                }
            }
        }
        return winner;
    }
}
