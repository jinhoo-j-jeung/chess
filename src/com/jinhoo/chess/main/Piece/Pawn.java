package com.jinhoo.chess.main.Piece;

import java.util.ArrayList;

class Pawn extends Piece{

    Pawn(int[][] board, int type, int x, int y){
        super(board, type, x, y);
    }

    /**
     * Finds all the possible locations to which a pawn can move
     * @return ArrayList that contains all the possible locations
     */
    ArrayList<String> findPossibleLocations() {
        ArrayList<String> possibleLocations = new ArrayList<>();
        if (this.type == 10) {
            if (this.x == 1) {
                if (this.board[x + 2][y] == 0) {
                    possibleLocations.add(Integer.toString(x + 2) + "," + Integer.toString(y));
                }
            }
            if(x+1 <= 7) {
                // Straight Movement
                if (board[x + 1][y] == 0) {
                    possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y));
                }
                // Diagonal Movement
                if (y > 0 && y < 7) {
                    // Left
                    if (checkPlayer2(board[x + 1][y - 1])) {
                        possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y - 1));
                    }
                    // Right
                    if (checkPlayer2(board[x + 1][y + 1])) {
                        possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y + 1));
                    }
                } else if (y == 0) {
                    // Right
                    if (checkPlayer2(board[x + 1][y + 1])) {
                        possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y + 1));
                    }
                } else {
                    // Left
                    if (checkPlayer2(board[x + 1][y - 1])) {
                        possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y - 1));
                    }
                }
            }
        }
        else if(type == 20){
            if (this.x == 6) {
                if (this.board[x - 2][y] == 0) {
                    possibleLocations.add(Integer.toString(x - 2) + "," + Integer.toString(y));
                }
            }
            if(x - 1 >=0) {
                // Straight Movement
                if (board[x - 1][y] == 0) {
                    possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y));
                }
                // Diagonal Movement
                if (y > 0 && y < 7) {
                    // Left
                    if (checkPlayer1(board[x - 1][y - 1])) {
                        possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y - 1));
                    }
                    // Right
                    if (checkPlayer1(board[x - 1][y + 1])) {
                        possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y + 1));
                    }
                } else if (y == 0) {
                    // Right
                    if (checkPlayer1(board[x - 1][y + 1])) {
                        possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y + 1));
                    }
                } else {
                    // Left
                    if (checkPlayer1(board[x - 1][y - 1])) {
                        possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y - 1));
                    }
                }
            }
        }
        return possibleLocations;
    }
}