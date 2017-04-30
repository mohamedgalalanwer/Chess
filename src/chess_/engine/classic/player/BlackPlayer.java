/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chess_.engine.classic.player;

import chess_.engine.Alliance;
import chess_.engine.classic.board.Board;
import chess_.engine.classic.board.Move;
import chess_.engine.classic.board.Move.KingSideCastleMove;
import chess_.engine.classic.board.Move.QueenSideCastleMove;
import chess_.engine.classic.board.Tile;
import chess_.engine.classic.pieces.Piece;
import chess_.engine.classic.pieces.Rook;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 *
 * @author moham
 */
public final class BlackPlayer extends Player {

    public BlackPlayer(final Board board,
                       final Collection<Move> whiteStandardLegals,
                       final Collection<Move> blackStandardLegals) {
        super(board, blackStandardLegals, whiteStandardLegals);
    }

    @Override
    protected Collection<Move> calculateKingCastles(final Collection<Move> playerLegals,
                                                    final Collection<Move> opponentLegals) {

        final List<Move> kingCastles = new ArrayList<>();

        if(this.playerKing.isFirstMove() && this.playerKing.getPiecePosition() == 4 && !isInCheck()) {
            //blacks king side castle
            if(!this.board.getTile(5).isTileOccupied() && !this.board.getTile(6).isTileOccupied()) {
                final Tile rookTile = this.board.getTile(7);
                if(rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove() &&
                   Player.calculateAttacksOnTile(5, opponentLegals).isEmpty() &&
                   Player.calculateAttacksOnTile(6, opponentLegals).isEmpty() &&
                   rookTile.getPiece().getPieceType().isRook()) {
                    kingCastles.add(
                            new KingSideCastleMove(this.board, this.playerKing, 6, (Rook) rookTile.getPiece(), rookTile.getTileCoordinate(), 5));
                }
            }
            //blacks queen side castle
            if(!this.board.getTile(1).isTileOccupied() && !this.board.getTile(2).isTileOccupied() &&
               !this.board.getTile(3).isTileOccupied()) {
                final Tile rookTile = this.board.getTile(0);
                if(rookTile.isTileOccupied() && rookTile.getPiece().isFirstMove() &&
                   Player.calculateAttacksOnTile(2, opponentLegals).isEmpty() &&
                   Player.calculateAttacksOnTile(3, opponentLegals).isEmpty() &&
                   rookTile.getPiece().getPieceType().isRook()) {
                    kingCastles.add(
                            new QueenSideCastleMove(this.board, this.playerKing, 2, (Rook) rookTile.getPiece(), rookTile.getTileCoordinate(), 3));
                }
            }
        }
        return ImmutableList.copyOf(kingCastles);
    }

    @Override
    public WhitePlayer getOpponent() {
        return this.board.whitePlayer();
    }

    @Override
    public Collection<Piece> getActivePieces() {
        return this.board.getBlackPieces();
    }

    @Override
    public Alliance getAlliance() {
        return Alliance.BLACK;
    }

    @Override
    public String toString() {
        return Alliance.BLACK.toString();
    }

}