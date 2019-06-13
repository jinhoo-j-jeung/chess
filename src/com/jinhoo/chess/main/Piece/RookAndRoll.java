package com.jinhoo.chess.main.Piece;

import java.util.ArrayList;
import java.util.Random;

class RookAndRoll extends Piece {

    RookAndRoll(int[][] board, int type, int x, int y){
        super(board, type, x, y);
    }

    /**
     * Finds all the possible locations to which a rook and roll can move
     * @return ArrayList that contains all the possible locations
     */
    ArrayList<String> findPossibleLocations() {
        // If the selected piece is a player 1 rook and roll
        Rook rook = null;
        if(type == 17) {
            type = 13;
            rook = new Rook(board, type, x, y);
        }
        // If the selected piece is a player 2 rook and roll
        else if(type == 27) {
            type = 23;
            rook = new Rook(board, type, x, y);
        }
        ArrayList<String> possibleLocations = rook.findPossibleLocations();
        System.out.println("Rolling the dice!");
        Random rand = new Random();
        int x = rand.nextInt(8);
        int y = rand.nextInt(8);
        if(!possibleLocations.contains(Integer.toString(x) + "," + Integer.toString(y)))
            possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y));
        System.out.println("Random location is "+x+","+y);
        return possibleLocations;
    }
}
