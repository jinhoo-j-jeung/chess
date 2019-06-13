package com.jinhoo.chess.main.Piece;

import java.util.ArrayList;

class King extends Piece{

    King(int[][] board, int type, int x, int y){
        super(board, type, x, y);
    }

    /**
     * Finds all the possible locations to which a king can move
     * @return ArrayList that contains all the possible locations
     */
    ArrayList<String> findPossibleLocations(){
        ArrayList<String> possibleLocations = new ArrayList<>();
        // If the selected piece is a player 1 king
        if (type == 11) {
            if (x - 1 >= 0) {
                if(y - 1 >= 0) {
                    if(board[x - 1][y - 1] == 0 || checkPlayer2(board[x - 1][y - 1]))
                        possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y - 1));
                }
                if(y + 1 < 8) {
                    if(board[x - 1][y + 1] == 0 || checkPlayer2(board[x - 1][y + 1])) {
                        possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y + 1));
                    }
                }
                if(board[x - 1][y] == 0 || checkPlayer2(board[x - 1][y]))
                    possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y));
            }
            if (x + 1 < 8) {
                if (y - 1 >= 0) {
                    if (board[x + 1][y - 1] == 0 || checkPlayer2(board[x + 1][y - 1]))
                        possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y - 1));
                }
                if (y + 1 < 8) {
                    if (board[x + 1][y + 1] == 0 || checkPlayer2(board[x + 1][y + 1]))
                        possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y + 1));
                }
                if (board[x + 1][y] == 0 || checkPlayer2(board[x + 1][y]))
                    possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y));
            }
            if (y - 1 >= 0) {
                if (board[x][y - 1] == 0 || checkPlayer2(board[x][y - 1]))
                    possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y - 1));
            }
            if (y + 1 < 8) {
                if (board[x][y + 1] == 0 || checkPlayer2(board[x][y + 1]))
                    possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y + 1));
            }
        }
        // If the selected piece is a player 2 King
        else if(type == 21) {
            if (x - 1 >= 0) {
                if(y - 1 >= 0) {
                    if(board[x - 1][y - 1] == 0 || checkPlayer1(board[x - 1][y - 1]))
                        possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y - 1));
                }
                if(y + 1 < 8) {
                    if(board[x - 1][y + 1] == 0 || checkPlayer1(board[x - 1][y + 1])) {
                        possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y + 1));
                    }
                }
                if(board[x - 1][y] == 0 || checkPlayer1(board[x - 1][y]))
                    possibleLocations.add(Integer.toString(x - 1) + "," + Integer.toString(y));
            }
            if (x + 1 < 8) {
                if (y - 1 >= 0) {
                    if (board[x + 1][y - 1] == 0 || checkPlayer1(board[x + 1][y - 1]))
                        possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y - 1));
                }
                if (y + 1 < 8) {
                    if (board[x + 1][y + 1] == 0 || checkPlayer1(board[x + 1][y + 1]))
                        possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y + 1));
                }
                if (board[x + 1][y] == 0 || checkPlayer1(board[x + 1][y]))
                    possibleLocations.add(Integer.toString(x + 1) + "," + Integer.toString(y));
            }
            if (y - 1 >= 0) {
                if (board[x][y - 1] == 0 || checkPlayer1(board[x][y - 1]))
                    possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y - 1));
            }
            if (y + 1 < 8) {
                if (board[x][y + 1] == 0 || checkPlayer1(board[x][y + 1]))
                    possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y + 1));
            }
        }
        return possibleLocations;
    }
}
