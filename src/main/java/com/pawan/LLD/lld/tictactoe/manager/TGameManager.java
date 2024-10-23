package com.pawan.LLD.lld.tictactoe.manager;

import com.pawan.LLD.lld.tictactoe.dao.TGameDao;
import com.pawan.LLD.lld.tictactoe.dto.TCellDTO;
import com.pawan.LLD.lld.tictactoe.dto.TGameDTO;
import com.pawan.LLD.lld.tictactoe.dto.TPlayerDTO;
import com.pawan.LLD.lld.tictactoe.exceptions.TGameException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class TGameManager {

    private final TGameDao gameDao;

    @Autowired
    private TGameManager(TGameDao gameDao) {
        this.gameDao = gameDao;
    }

    public void playGameWithMove(TGameDTO game, int move) {
        int size = game.getBoard().getSize();
        int row = move/size;
        int column = move%size;
        TCellDTO cellDTO = game.getBoard().getCells()[row][column];
        if(StringUtils.isNotBlank(cellDTO.getPlayer())) {
            throw new TGameException("Player already has move on this cell, please play on empty cell.");
        }
        TPlayerDTO turn = game.getPlayers().get(game.getTurn());
        cellDTO.setPlayer(turn.getMark());
        gameDao.save(game);
        log.info("Player: {} played {} on: {}, {} cells on his turn.", turn.getName(), turn.getMark(), row, column);
    }

    public String updateTurn(TGameDTO game) {
        int turn = game.getTurn() == 0 ? 1 : 0;
        game.setTurn(turn);
        gameDao.save(game);
        log.info("Player: {} has turn to play game.", game.getPlayers().get(game.getTurn()).getName());
        return String.format("Player: %s has turn to play game.", game.getPlayers().get(game.getTurn()).getName());
    }

    public boolean checkWinner(TGameDTO game) {
        int size = game.getBoard().getSize();
        TCellDTO[][] cells = game.getBoard().getCells();
        String turn = game.getPlayers().get(game.getTurn()).getMark();
        for(int i=0; i<size%3; i++) {
            for(int j=0; j<size%3; j++) {
                if (turn.equals(cells[3*i+0][3*j+0].getPlayer()) && turn.equals(cells[3*i+0][1].getPlayer()) && turn.equals(cells[3*i+0][2].getPlayer())) {
                    return true;
                } else if (turn.equals(cells[3*i+1][3*j+0].getPlayer()) && turn.equals(cells[3*i+1][3*j+1].getPlayer()) && turn.equals(cells[3*i+1][3*j+2].getPlayer())) {
                    return true;
                } else if (turn.equals(cells[3*i+2][3*j+0].getPlayer()) && turn.equals(cells[3*i+2][3*j+1].getPlayer()) && turn.equals(cells[3*i+2][3*j+2].getPlayer())) {
                    return true;
                } else if (turn.equals(cells[3*i+0][3*j+0].getPlayer()) && turn.equals(cells[3*i+1][3*j+0].getPlayer()) && turn.equals(cells[3*i+2][3*j+0].getPlayer())) {
                    return true;
                } else if (turn.equals(cells[3*i+0][3*j+1].getPlayer()) && turn.equals(cells[3*i+1][3*j+1].getPlayer()) && turn.equals(cells[3*i+2][3*j+1].getPlayer())) {
                    return true;
                } else if (turn.equals(cells[3*i+0][3*j+2].getPlayer()) && turn.equals(cells[3*i+1][3*j+2].getPlayer()) && turn.equals(cells[3*i+2][3*j+2].getPlayer())) {
                    return true;
                } else if (turn.equals(cells[3*i+0][3*j+0].getPlayer()) && turn.equals(cells[3*i+1][3*j+1].getPlayer()) && turn.equals(cells[3*i+2][3*j+2].getPlayer())) {
                    return true;
                } else if (turn.equals(cells[3*i+0][3*j+2].getPlayer()) && turn.equals(cells[3*i+1][3*j+2].getPlayer()) && turn.equals(cells[3*i+2][3*j+0].getPlayer())) {
                    return true;
                }
            }
        }

        return false;
    }

    public void validateGame(int move, TGameDTO game) {
        int size = game.getBoard().getSize();
        if (move<0 || move>=size*size) {
            throw new TGameException(String.format("Play a valid move between 0 to %s*%s", size, size));
        }
        if (game.getWinner()!=null) {
            throw new TGameException(String.format("Play %s already win this game.", game.getWinner().getName()));
        }
    }

    public boolean checkDraw(TGameDTO game) {
        for(TCellDTO[] cell : game.getBoard().getCells()) {
            for(TCellDTO c : cell) {
                if(StringUtils.isBlank(c.getPlayer())) {
                    return false;
                }
            }
        }
        return true;
    }
}
