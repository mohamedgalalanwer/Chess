/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_.pgn;

import chess_.engine.classic.board.Board;
import chess_.engine.classic.board.Move;
import chess_.engine.classic.player.Player;

/**
 *
 * @author moham
 */
public interface PGNPersistence {

    void persistGame(Game game);

    Move getNextBestMove(Board board, Player player, String gameText);
    
}
