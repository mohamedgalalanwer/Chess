/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_.engine.classic.player.ai;

import chess_.engine.classic.board.Board;

/**
 *
 * @author moham
 */
public interface BoardEvaluator {

    int evaluate(Board board, int depth);


    
}
