package com.aquilams;

import boardgame.Board;
import chess.ChessMatch;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        ChessMatch chessMatch = new ChessMatch();
        UI.printBoard(chessMatch.getPieces());
    }
}
