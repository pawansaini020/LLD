package com.pawan.LLD.lld.snakeandladder.manager;

import com.pawan.LLD.lld.snakeandladder.dto.Cell;
import com.pawan.LLD.lld.snakeandladder.dto.Game;
import com.pawan.LLD.lld.snakeandladder.dto.Player;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;


@Slf4j
@Component
public class GameManager {


    public void playGameForPlayer(Game game, Player player) {
        int dicePosition = game.getDice().roll();
        log.info("Player {} role dice with number: {}", player.getName(), dicePosition);
        if(player.getPosition() + dicePosition <= game.getBoard().getSize()) {
            player.setPosition(player.getPosition() + dicePosition);
            checkSnakeAndLadderImpact(game, player);
        }
        log.info("Player {} new postion is: {}", player.getName(), player.getPosition());
    }

    private void checkSnakeAndLadderImpact(Game game, Player player) {
        Cell cellPosition = game.getBoard().getCells().get(player.getPosition());
        if(cellPosition.getLadder() != null) {
            log.info("Player {} is impacted with ladder so jump from : {} to: {}", player.getName(), player.getPosition(), cellPosition.getLadder().getEndPosition());
            player.setPosition(cellPosition.getLadder().getEndPosition());
        } else if(cellPosition.getSnake() != null) {
            player.setPosition(cellPosition.getSnake().getEndPosition());
            log.info("Player {} is impacted with snake so jump from : {} to: {}", player.getName(), player.getPosition(), cellPosition.getSnake().getEndPosition());
        }
    }

    public boolean isWinner(Game game, Player player) {
        return player.getPosition() == game.getBoard().getSize();
    }
}
