package com.jinhoo.chess.main.Piece;

import java.util.ArrayList;

class Bishop extends Piece{

    Bishop(int[][] board, int type, int x, int y){
        super(board, type, x, y);
    }

    /**
     * Finds all the possible locations to which a bishop can move
     * @return ArrayList that contains all the possible locations
     */
    ArrayList<String> findPossibleLocations() {
        ArrayList<String> possibleLocations = new ArrayList<>();
        // If the selected piece is a player 1 bishop
        if (type == 15) {
            //Up-Right
            int i = 1;
            int j = 1;
            while (checkWithinBound(x - i, y + j) && board[x - i][y + j] == 0) {
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y + j));
                i++;
                j++;
            }
            if (checkWithinBound(x - i, y + j) && checkPlayer2(board[x - i][y + j]))
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y + j));
            //Up-Left
            i = 1;
            j = 1;
            while (checkWithinBound(x - i, y - j) && board[x - i][y - j] == 0) {
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y - j));
                i++;
                j++;
            }
            if (checkWithinBound(x - i, y - j) && checkPlayer2(board[x - i][y - j]))
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y - j));
            //Down-Right
            i = 1;
            j = 1;
            while (checkWithinBound(x + i, y + j) && board[x + i][y + j] == 0) {
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y + j));
                i++;
                j++;
            }
            if (checkWithinBound(x + i, y + j) && checkPlayer2(board[x + i][y + j]))
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y + j));
            //Down-Left
            i = 1;
            j = 1;
            while (checkWithinBound(x + i, y - j) && board[x + i][y - j] == 0) {
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y - j));
                i++;
                j++;
            }
            if (checkWithinBound(x + i, y - j) && checkPlayer2(board[x + i][y - j]))
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y - j));
        }
        // If the selected piece is a player 2 bishop
        else if (type == 25) {
            //Up-Right
            int i = 1;
            int j = 1;
            while (checkWithinBound(x - i, y + j) && y + j < 8 && board[x - i][y + j] == 0) {
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y + j));
                i++;
                j++;
            }
            if (checkWithinBound(x - i, y + j) && checkPlayer1(board[x - i][y + j]))
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y + j));
            //Up-Left
            i = 1;
            j = 1;
            while (checkWithinBound(x - i, y - j) && board[x - i][y - j] == 0) {
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y - j));
                i++;
                j++;
            }
            if (checkWithinBound(x - i, y - j) && checkPlayer1(board[x - i][y - j]))
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y - j));
            //Down-Right
            i = 1;
            j = 1;
            while (checkWithinBound(x + i, y + j) && board[x + i][y + j] == 0) {
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y + j));
                i++;
                j++;
            }
            if (checkWithinBound(x + i, y + j) && checkPlayer1(board[x + i][y + j]))
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y + j));
            //Down-Left
            i = 1;
            j = 1;
            while (checkWithinBound(x + i, y - j) && board[x + i][y - j] == 0) {
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y - j));
                i++;
                j++;
            }
            if (checkWithinBound(x + i, y - j) && checkPlayer1(board[x + i][y - j]))
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y - j));
        }
        return possibleLocations;
    }
}
