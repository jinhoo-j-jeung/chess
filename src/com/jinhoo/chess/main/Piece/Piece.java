package com.jinhoo.chess.main.Piece;

import java.util.ArrayList;
import java.util.Random;

public class Piece {
    int[][] board;
    int type;
    int x;
    int y;

    /**
     * Package-private constructor
     * @param board
     * @param type
     * @param x
     * @param y
     */
    public Piece(int[][] board, int type, int x, int y){
        this.board = board;
        this.type = type;
        this.x = x;
        this.y = y;
    }

    /**
     * Package-private Wrapper function for piece movements
     * @return ArrayList of string that contains possible locations to which the piece cam move.
     */
    public ArrayList<String> move() {
        if(type == 10 || type == 20) {
            Pawn pawn = new Pawn(board, type, x, y);
            return pawn.findPossibleLocations();
        }
        else if(type == 13 || type == 23) {
            Rook rook = new Rook(board, type, x, y);
            return rook.findPossibleLocations();
        }
        else if(type == 14 || type == 24) {
            Knight knight = new Knight(board, type, x ,y);
            return knight.findPossibleLocations();
        }
        else if(type == 15 || type == 25) {
            Bishop bishop = new Bishop(board, type, x, y);
            return bishop.findPossibleLocations();
        }
        else if(type == 12 || type == 22) {
            Queen queen = new Queen(board, type, x, y);
            return queen.findPossibleLocations();
        }
        else if(type == 11 || type == 21) {
            King king = new King(board, type, x, y);
            return king.findPossibleLocations();
        }
        else if(type == 16 || type == 26) {
            DarkKnight dark_knight = new DarkKnight(board, type, x, y);
            return dark_knight.findPossibleLocations();
        }
        else if(type == 17 || type == 27) {
            RookAndRoll rook_and_roll = new RookAndRoll(board, type, x, y);
            return rook_and_roll.findPossibleLocations();
        }
        else return null;
    }

    boolean checkWithinBound(int x, int y) {
        return (x >= 0 && x <= 7 && y >= 0 && y <=7);
    }

    boolean checkPlayer1(int type) {
        return (type >= 10 && type <=17);
    }

    boolean checkPlayer2(int type) {
        return (type >= 20 && type <= 27);
    }
}