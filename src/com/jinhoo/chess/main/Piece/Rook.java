package com.jinhoo.chess.main.Piece;

import java.util.ArrayList;

class Rook extends Piece{

    Rook(int[][] board, int type, int x, int y){
        super(board, type, x, y);
    }

    /**
     * Finds all the possible locations to which a rook can move
     * @return ArrayList that contains all the possible locations
     */
    ArrayList<String> findPossibleLocations(){
        ArrayList<String> possibleLocations = new ArrayList<>();
        // If the selected piece is a player 1 rook
        if (type == 13) {
            // Down Movement
            int i = 1;
            while (checkWithinBound(x+i, y) && board[x + i][y] == 0) {
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y));
                i++;
            }
            if (checkWithinBound(x+i, y) && checkPlayer2(board[x+i][y]))
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y));
            // Up Movement
            i = 1;
            while (checkWithinBound(x-i, y) && board[x - i][y] == 0) {
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y));
                i++;
            }
            if (checkWithinBound(x-i, y) && checkPlayer2(board[x - i][y]))
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y));
            // Right Movement
            int j = 1;
            while (checkWithinBound(x, y+j) && board[x][y + j] == 0) {
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y + j));
                j++;
            }
            if (checkWithinBound(x, y+j) && checkPlayer2(board[x][y + j]))
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y + j));
            // Left Movement
            j = 1;
            while (checkWithinBound(x, y-j) && board[x][y - j] == 0) {
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y - j));
                j++;
            }
            if (checkWithinBound(x, y-j) && checkPlayer2(board[x][y - j]))
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y - j));
        }
        // If the selected piece is a player 2 rook
        else if (type == 23) {
            // Down Movement
            int i = 1;
            while (checkWithinBound(x+i, y) && board[x + i][y] == 0) {
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y));
                i++;
            }
            if (checkWithinBound(x+i, y) && checkPlayer1(board[x + i][y]))
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y));
            // Up Movement
            i = 1;
            while (checkWithinBound(x-i, y) && board[x - i][y] == 0) {
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y));
                i++;
            }
            if (checkWithinBound(x-i, y) && checkPlayer1(board[x - i][y]))
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y));
            // Right Movement
            int j = 1;
            while (checkWithinBound(x, y+j) && board[x][y + j] == 0) {
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y + j));
                j++;
            }
            if (checkWithinBound(x, y+j) && checkPlayer1(board[x][y + j]))
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y + j));
            // Left Movement
            j = 1;
            while (checkWithinBound(x, y-j) && board[x][y - j] == 0) {
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y - j));
                j++;
            }
            if (checkWithinBound(x, y-j) && checkPlayer1(board[x][y - j]))
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y - j));
        }
        return possibleLocations;
    }
}
