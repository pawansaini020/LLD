package com.pawan.LLD.lld.tictactoe2.manager;

import com.pawan.LLD.lld.tictactoe2.dto.TTCell;
import com.pawan.LLD.lld.tictactoe2.dto.TTGame;
import com.pawan.LLD.lld.tictactoe2.exception.InvalidException;
import com.pawan.LLD.lld.tictactoe2.utils.TTGameUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

/**
 * @author Pawan Saini
 * Created on 05/10/24.
 */
@Slf4j
@Component
public class TTGameManager {

    public boolean isValidMove(TTGame game, int size, int x, int y) {

        if(game.getWinner()!=null) {
            log.info("{}[{}] is already winner of the game.", game.getPlayers()[game.getTurn()].getName(), game.getPlayers()[game.getTurn()].getMove());
            throw new InvalidException(String.format("%s[%s] is already winner of the game.", game.getPlayers()[game.getTurn()].getName(), game.getPlayers()[game.getTurn()].getMove()));
        }
        if(isGameDraw(game, size)) {
            log.info("Game is already draw between players: {}.", game.getPlayers());
            throw new InvalidException(String.format("Game is already draw between players: %s.", game.getPlayers().toString()));
        }
        if(x<0 || y<0 || x>=size || y>=size) {
            log.info("{} your move is out of the board size {} , {}", game.getPlayers()[game.getTurn()].getName(), x, y);
            throw new InvalidException(String.format("%s your move is out of the board size %s , %s", game.getPlayers()[game.getTurn()].getName(), x, y));
        }
        if(StringUtils.isNotBlank(game.getBoard().getCells()[x][y].getMove())) {
            log.info("{} your move is on the already filled move {} , {}", game.getPlayers()[game.getTurn()].getName(), x, y);
            throw new InvalidException(String.format("%s your move is on the already filled move %s , %s", game.getPlayers()[game.getTurn()].getName(), x, y));
        }
        return true;
    }

    private boolean isGameDraw(TTGame game, int size) {

        for(int i=0; i<size; i++) {
            for(int j=0; j<size; j++) {
                if(StringUtils.isBlank(game.getBoard().getCells()[i][j].getMove())) {
                    return false;
                }
            }
        }
        return true;
    }

    public void addMove(TTGame game, int size, int x, int y) {
        game.getBoard().getCells()[x][y].setMove(game.getPlayers()[game.getTurn()].getMove());
        log.info("Player {} played a new move {} on position: {}, {}", game.getPlayers()[game.getTurn()].getName(), game.getPlayers()[game.getTurn()].getMove(), x, y);
        TTGameUtils.printGameState(game, size);
    }

    public boolean isWinner(TTGame game, int size) {
        TTCell[][] cells = game.getBoard().getCells();
        for(int i=0; i<size; i=i+3) {
            for(int j=0; j<size; j=j+3) {
                if(checkWinner(cells, i, j)) {
                    game.setWinner(game.getPlayers()[game.getTurn()]);
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkWinner(TTCell[][] cells, int i, int j) {
        if(cells[i][j].getMove()!=null && cells[i][j+1].getMove()!=null && cells[i][j].getMove().equals(cells[i][j+1].getMove()) && cells[i][j+1].getMove().equals(cells[i][j+2].getMove())) {
            return true;
        }
        if(cells[i+1][j].getMove()!=null && cells[i+1][j+1].getMove()!=null && cells[i+1][j].getMove().equals(cells[i+1][j+1].getMove()) && cells[i+1][j+1].getMove().equals(cells[i+1][j+2].getMove())) {
            return true;
        }
        if(cells[i+2][j].getMove()!=null && cells[i+2][j+1].getMove()!=null && cells[i+2][j].getMove().equals(cells[i+2][j+1].getMove()) && cells[i+2][j+1].getMove().equals(cells[i+2][j+2].getMove())) {
            return true;
        }
        if(cells[i][j].getMove()!=null && cells[i+1][j].getMove()!=null && cells[i][j].getMove().equals(cells[i+1][j].getMove()) && cells[i+1][j].getMove().equals(cells[i+2][j].getMove())) {
            return true;
        }
        if(cells[i][j+1].getMove()!=null && cells[i+1][j+1].getMove()!=null && cells[i][j+1].getMove().equals(cells[i+1][j+1].getMove()) && cells[i+1][j+1].getMove().equals(cells[i+2][j+1].getMove())) {
            return true;
        }
        if(cells[i][j+2].getMove()!=null && cells[i+1][j+1].getMove()!=null && cells[i][j+2].getMove().equals(cells[i+1][j+2].getMove()) && cells[i+1][j+2].getMove().equals(cells[i+2][j+2].getMove())) {
            return true;
        }
        if(cells[i][j].getMove()!=null && cells[i+1][j+1].getMove()!=null && cells[i][j].getMove().equals(cells[i+1][j+1].getMove()) && cells[i+1][j+1].getMove().equals(cells[i+2][j+2].getMove())) {
            return true;
        }
        if(cells[i][j+2].getMove()!=null && cells[i+1][j+1].getMove()!=null && cells[i][j+2].getMove().equals(cells[i+1][j+1].getMove()) && cells[i+1][j+1].getMove().equals(cells[i+2][j].getMove())) {
            return true;
        }
        return false;
    }

    public void changeTurn(TTGame game) {
        int turn = (game.getTurn()+1)%game.getPlayers().length;
        game.setTurn(turn);
    }
}
