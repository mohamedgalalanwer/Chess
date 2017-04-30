/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_.engine.classic.board;

/**
 *
 * @author moham
 */
public enum MoveUtils {

    INSTANCE;

    public static int exchangeScore(final Move move) {
        if(move == Move.NULL_MOVE) {
            return 1;
        }
        return move.isAttack() ?
                5 * exchangeScore(move.getBoard().getTransitionMove()) :
                exchangeScore(move.getBoard().getTransitionMove());

    }

}

