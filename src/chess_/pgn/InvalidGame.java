/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_.pgn;

import java.util.Collections;

/**
 *
 * @author moham
 */
public class InvalidGame extends Game {

    final String malformedGameText;

    public InvalidGame(final PGNGameTags tags,
                       final String malformedGameText,
                       final String outcome) {
        super(tags, Collections.<String>emptyList(), outcome);
        this.malformedGameText = malformedGameText;
    }

    @Override
    public String toString() {
        return "Invalid Game " + this.tags;
    }

    @Override
    public boolean isValid() {
        return false;
    }    
}
