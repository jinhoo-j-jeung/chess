package com.jinhoo.chess.main.Piece;

import java.util.ArrayList;

class DarkKnight extends Piece {

    DarkKnight(int[][] board, int type, int x, int y){
        super(board, type, x, y);
    }

    /**
     * Finds all the possible locations to which a dark knight can move
     * @return ArrayList that contains all the possible locations
     */
    ArrayList<String> findPossibleLocations(){
        ArrayList<String> possibleLocations = new ArrayList<>();
        // If the selected piece is a player 1 dark knight
        if (type == 16) {
            // Up First and Right
            if (checkWithinBound(x-2, y+1) && board[x - 2][y + 1] != 11)
                possibleLocations.add(Integer.toString(x - 2) + "," + Integer.toString(y + 1));
            // Up First and Left
            if (checkWithinBound(x-2, y-1) && board[x - 2][y - 1] != 11)
                possibleLocations.add(Integer.toString(x - 2) + "," + Integer.toString(y - 1));
            // Down First and Right
            if (checkWithinBound(x+2, y+1) && board[x + 2][y + 1] != 11)
                possibleLocations.add(Integer.toString(x + 2) + "," + Integer.toString(y + 1));
            // Down First and Left
            if (checkWithinBound(x+1, y-1) && board[x + 2][y - 1] != 11)
                possibleLocations.add(Integer.toString(x + 2) + "," + Integer.toString(y - 1));
            // Right First and Up
            if (checkWithinBound(x-1, y+2) && board[x - 1][y + 2] != 11)
                possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y + 2));
            // Right First and Down
            if (checkWithinBound(x+1, y+2) && board[x + 1][y + 2] != 11)
                possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y + 2));
            // Left First and Up
            if (checkWithinBound(x-1, y-2) && board[x - 1][y - 2] != 11)
                possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y - 2));
            // Left First and Down
            if (checkWithinBound(x+1, y-2) && board[x + 1][y - 2] != 11)
                possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y - 2));
        }
        // If the selected piece is a player 2 dark knight
        else if (type == 26) {
            if (checkWithinBound(x-2, y+1) && board[x - 2][y + 1] != 21)
                possibleLocations.add(Integer.toString(x - 2) + "," + Integer.toString(y + 1));
            // Up First and Left
            if (checkWithinBound(x-2, y-1) && board[x - 2][y - 1] != 21)
                possibleLocations.add(Integer.toString(x - 2) + "," + Integer.toString(y - 1));
            // Down First and Right
            if (checkWithinBound(x+2, y+1) && board[x + 2][y + 1] != 21)
                possibleLocations.add(Integer.toString(x + 2) + "," + Integer.toString(y + 1));
            // Down First and Left
            if (checkWithinBound(x+1, y-1) && board[x + 2][y - 1] != 21)
                possibleLocations.add(Integer.toString(x + 2) + "," + Integer.toString(y - 1));
            // Right First and Up
            if (checkWithinBound(x-1, y+2) && board[x - 1][y + 2] != 21)
                possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y + 2));
            // Right First and Down
            if (checkWithinBound(x+1, y+2) && board[x + 1][y + 2] != 21)
                possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y + 2));
            // Left First and Up
            if (checkWithinBound(x-1, y-2) && board[x - 1][y - 2] != 21)
                possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y - 2));
            // Left First and Down
            if (checkWithinBound(x+1, y-2) && board[x + 1][y - 2] != 21)
                possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y - 2));
        }
        return possibleLocations;
    }
}