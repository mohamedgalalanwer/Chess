/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_.engine.classic.player.ai;

import chess_.engine.classic.board.Board;
import chess_.engine.classic.board.Move;

/**
 *
 * @author moham
 */
public interface MoveStrategy {

    long getNumBoardsEvaluated();

    Move execute(Board board, int depth);

}
