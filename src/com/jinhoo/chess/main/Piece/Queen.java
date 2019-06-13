package com.jinhoo.chess.main.Piece;

import java.util.ArrayList;

class Queen extends Piece{

    Queen(int[][] board, int type, int x, int y){
        super(board, type, x, y);
    }

    /**
     * Finds all the possible locations to which a queen can move
     * @return ArrayList that contains all the possible locations
     */
    ArrayList<String> findPossibleLocations(){
        ArrayList<String> possibleLocations = new ArrayList<>();
        // If the selected piece is a player 1 queen
        if (type == 12) {
            // Straight Movement
            // Up Movement
            int i = 1;
            while(x-i >= 0 && board[x-i][y] == 0) {
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y));
                i++;
            }
            if(x-i >= 0 && checkPlayer2(board[x-i][y]))
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y));
            // Down Movement
            i = 1;
            while(x+i < 8 && board[x+i][y] == 0) {
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y));
                i++;
            }
            if(x+i < 8 && checkPlayer2(board[x+i][y]))
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y));
            // Right Movement
            int j = 1;
            while(y+j < 8 && board[x][y+j] == 0) {
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y+j));
                j++;
            }
            if(y+j < 8 && checkPlayer2(board[x][y+j]))
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y + j));
            // Left Movement
            j = 1;
            while(y-j >= 0 && board[x][y-j] == 0) {
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y-j));
                j++;
            }
            if(y-j >= 0 && checkPlayer2(board[x][y-j]))
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y - j));
            // Diagonal Movement
            //Up-Right
            i = 1;
            j = 1;
            while (x - i >= 0 && y + j < 8 && board[x - i][y + j] == 0) {
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y + j));
                i++;
                j++;
            }
            if (x - i >= 0 && y + j < 8 && checkPlayer2(board[x - i][y + j]))
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y + j));
            //Up-Left
            i = 1;
            j = 1;
            while (x - i >= 0 && y - j >= 0 && board[x - i][y - j] == 0) {
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y - j));
                i++;
                j++;
            }
            if (x - i >= 0 && y - j >= 0 && checkPlayer2(board[x - i][y - j]))
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y - j));
            //Down-Right
            i = 1;
            j = 1;
            while (x + i < 8 && y + j < 8 && board[x + i][y + j] == 0) {
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y + j));
                i++;
                j++;
            }
            if (x + i < 8 && y + j < 8 && checkPlayer2(board[x + i][y + j]))
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y + j));
            //Down-Left
            i = 1;
            j = 1;
            while (x + i < 8 && y - j >= 0 && board[x + i][y - j] == 0) {
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y - j));
                i++;
                j++;
            }
            if (x + i < 8 && y - j >= 0 && checkPlayer2(board[x + i][y - j]))
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y - j));
        }
        // If the selected piece is a player 2 Queen
        else if (type == 22) {
            // Straight Movement
            // Up Movement
            int i = 1;
            while(x-i >= 0 && board[x-i][y] == 0) {
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y));
                i++;
            }
            if(x-i >= 0 && checkPlayer1(board[x-i][y]))
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y));
            // Down Movement
            i = 1;
            while(x+i < 8 && board[x+i][y] == 0) {
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y));
                i++;
            }
            if(x+i < 8 && checkPlayer1(board[x+i][y]))
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y));
            // Right Movement
            int j = 1;
            while(y+j < 8 && board[x][y+j] == 0) {
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y+j));
                j++;
            }
            if(y+j < 8 && checkPlayer1(board[x][y+j]))
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y + j));
            // Left Movement
            j = 1;
            while(y-j >= 0 && board[x][y-j] == 0) {
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y-j));
                j++;
            }
            if(y-j >= 0 && checkPlayer1(board[x][y-j]))
                possibleLocations.add(Integer.toString(x) + "," + Integer.toString(y - j));
            // Diagonal Movement
            //Up-Right
            i = 1;
            j = 1;
            while (x - i >= 0 && y + j < 8 && board[x - i][y + j] == 0) {
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y + j));
                i++;
                j++;
            }
            if (x - i >= 0 && y + j < 8 && checkPlayer1(board[x - i][y + j]))
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y + j));
            //Up-Left
            i = 1;
            j = 1;
            while (x - i >= 0 && y - j >= 0 && board[x - i][y - j] == 0) {
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y - j));
                i++;
                j++;
            }
            if (x - i >= 0 && y - j >= 0 && checkPlayer1(board[x - i][y - j]))
                possibleLocations.add(Integer.toString(x - i) + "," + Integer.toString(y - j));
            //Down-Right
            i = 1;
            j = 1;
            while (x + i < 8 && y + j < 8 && board[x + i][y + j] == 0) {
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y + j));
                i++;
                j++;
            }
            if (x + i < 8 && y + j < 8 && checkPlayer1(board[x + i][y + j]))
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y + j));
            //Down-Left
            i = 1;
            j = 1;
            while (x + i < 8 && y - j >= 0 && board[x + i][y - j] == 0) {
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y - j));
                i++;
                j++;
            }
            if (x + i < 8 && y - j >= 0 && checkPlayer1(board[x + i][y - j]))
                possibleLocations.add(Integer.toString(x + i) + "," + Integer.toString(y - j));
        }
        return possibleLocations;
    }
}
