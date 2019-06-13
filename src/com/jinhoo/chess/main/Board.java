package com.jinhoo.chess.main;

import com.jinhoo.chess.main.Piece.Piece;

import java.util.ArrayList;
import java.util.Arrays;

public class Board {
    public static final int PAWN_P1 = 10;
    public static final int KING_P1 = 11;
    public static final int QUEEN_P1 = 12;
    public static final int ROOK_P1 = 13;
    public static final int KNIGHT_P1 = 14;
    public static final int BISHOP_P1 = 15;
    public static final int DARKKNIGHT_P1 = 16;
    public static final int ROOKANDROLL_P1 = 17;
    public static final int PAWN_P2 = 20;
    public static final int KING_P2 = 21;
    public static final int QUEEN_P2 = 22;
    public static final int ROOK_P2 = 23;
    public static final int KNIGHT_P2 = 24;
    public static final int BISHOP_P2 = 25;
    public static final int DARKKNIGHT_P2 = 26;
    public static final int ROOKANDROLL_P2 = 27;

    private int winner;
    private int stalemate_count;
    private int[][] board;
    private int selected_x, selected_y;
    private int king1_x, king1_y;
    private int king2_x, king2_y;
    private boolean p1_checked, p2_checked;
    private ArrayList<String> dead;
    private ArrayList<String> past_moves;

    /**
      * Default Constructor
      */
    public Board() {
        board = new int[8][8];
        winner = -1;
        stalemate_count = 0;
        p1_checked = false;
        p2_checked = false;
        dead = new ArrayList<>();
        past_moves = new ArrayList<>();

        // Pawn
        Arrays.fill(board[1], PAWN_P1);
        Arrays.fill(board[6], PAWN_P2);

        // rook
        board[0][0] = ROOK_P1;
        board[0][7] = ROOK_P1;
        board[7][0] = ROOK_P2;
        board[7][7] = ROOK_P2;

        // Knight
        board[0][1] = KNIGHT_P1;
        board[0][6] = KNIGHT_P1;
        board[7][1] = KNIGHT_P2;
        board[7][6] = KNIGHT_P2;

        // Bishop
        board[0][2] = BISHOP_P1;
        board[0][5] = BISHOP_P1;
        board[7][2] = BISHOP_P2;
        board[7][5] = BISHOP_P2;

        // Queen
        board[0][4] = QUEEN_P1;
        board[7][3] = QUEEN_P2;

        // King
        board[0][3] = KING_P1;
        board[7][4] = KING_P2;
        king1_x = 0;
        king1_y = 3;
        king2_x = 7;
        king2_y = 4;
    }

    /**
     * Customizable Board Constructor
     * @param board
     */
    public Board(int[][] board) {
        this.board = board;

        winner = -1;
        stalemate_count = 0;
        p1_checked = false;
        p2_checked = false;
        dead = new ArrayList<>();
        past_moves = new ArrayList<>();

        king1_x = -1;
        king1_y = -1;
        king2_x = -1;
        king2_y = -1;
        for(int i = 0; i < 8; i++) {
            for(int j = 0; j < 8; j++) {
                if(board[i][j] == 11) {
                    king1_x = i;
                    king1_y = j;
                }
                else if(board[i][j] == 21) {
                    king2_x = i;
                    king2_y = j;
                }
            }
        }
        if(king1_x == -1 || king2_x == -1) {
            System.out.println("You need to have Kings for both players");
            this.board = null;
        }
    }

    /**
     * Getter function for board
     * @return board
     */
    public int[][] getBoard(){
        return this.board;
    }

    /**
     * Helper function that prints the board on the console
     */
    public void printBoard() {
        for (int i = 0; i < 8; i++) {
            System.out.print("|");
            for (int j = 0; j < 8; j++) {
                System.out.print(" ");
                if (board[i][j] == 0) System.out.print("-- |");
                else if(board[i][j]==10) System.out.print("BP |");
                else if(board[i][j]==11) System.out.print("BK |");
                else if(board[i][j]==12) System.out.print("BQ |");
                else if(board[i][j]==13) System.out.print("BR |");
                else if(board[i][j]==14) System.out.print("BN |");
                else if(board[i][j]==15) System.out.print("BB |");
                else if(board[i][j]==16) System.out.print("BD |");
                else if(board[i][j]==17) System.out.print("BO |");
                else if(board[i][j]==20) System.out.print("WP |");
                else if(board[i][j]==21) System.out.print("WK |");
                else if(board[i][j]==22) System.out.print("WQ |");
                else if(board[i][j]==23) System.out.print("WR |");
                else if(board[i][j]==24) System.out.print("WN |");
                else if(board[i][j]==25) System.out.print("WB |");
                else if(board[i][j]==26) System.out.print("WD |");
                else if(board[i][j]==27) System.out.print("WO |");
            }
            System.out.println();
        }
    }

    /**
     * Selects the chess piece that the user wants to move
     * @param player
     * @param x
     * @param y
     * @return true if the user selected the valid piece; false else
     */
    public boolean selectPiece(int player, int x, int y) {
        if(x > 7 || x < 0) return false;
        if(player == 1) {
            if (board[x][y] >= 10 && board[x][y] <=17) {
                selected_x = x;
                selected_y = y;
                return true;
            }
        }
        else {
            if (board[x][y] >= 20 && board[x][y] <=27) {
                selected_x = x;
                selected_y = y;
                return true;
            }
        }
        selected_x = -1;
        selected_y = -1;
        return false;
    }

    /**
     * Finds possible locations to which the selected piece can move
     * @return ArrayList of String that contains possible locations
     */
    public ArrayList<String> getPossibleLocations() {
        // If no piece is selected, return null
        if (selected_x == -1 || selected_y == -1) return null;
        int type = board[selected_x][selected_y];
        Piece p = new Piece(this.board, type, selected_x, selected_y);
        return p.move();
    }

    /**
     * Moves the selected piece to the selected location
     * @param player
     * @param x
     * @param y
     */
    public void movePiece(int player, int x, int y) {
        if(player == 1 && board[x][y] == 21) winner = player;
        if(player == 2 && board[x][y] == 11) winner = player;
        if(board[x][y] != 0) {
            String dead_info = player%2+1 + "," + board[x][y] + "," + x + "," + y;
            dead.add(dead_info);
        }
        if(board[selected_x][selected_y] == 11) {
            king1_x = x;
            king1_y = y;
        }
        else if(board[selected_x][selected_y] == 21) {
            king2_x = x;
            king2_y = y;
        }
        board[x][y] = board[selected_x][selected_y];
        board[selected_x][selected_y] = 0;
        selected_x = -1;
        selected_y = -1;
    }

    public void undo() {
        String past_move = past_moves.get(past_moves.size());
        past_moves.remove(past_moves.size());

    }

    /**
     * Checks whether the opponent is checked
     * @param player
     * @return true if the opponent is checked, else false
     */
    public boolean isCheck(int player) {
        ArrayList<String> pieces = findAllPieces(board, player);
        for(int i = 0; i < pieces.size(); i++) {
            String str = pieces.get(i);
            int type = Integer.parseInt(str.substring(0, 2));
            int x = Integer.parseInt(str.substring(3, 4));
            int y = Integer.parseInt(str.substring(5, 6));
            Piece p = new Piece(board, type, x, y);
            ArrayList<String> moves = p.move();
            if(player == 1 && moves.contains(king2_x+","+king2_y)) {
                p2_checked = true;
                return true;
            }
            else if(player ==2 && moves.contains(king1_x+","+king1_y)) {
                p1_checked = true;
                return true;
            }
        }
        return false;
    }

    /**
     * Checks whether the player is checkmated
     * @param player
     * @return if checkmated, true; else false
     */
    public boolean isCheckmate(int player) {
        if(player ==1 && p1_checked) {
            //
            if(noPossibleKingMoves(player)) return true;
            if(isCheck(2)) {
                winner = 2;
                return true;
            }
        }
        else if(player == 2 && p2_checked) {
            if(noPossibleKingMoves(player)) return true;
            if(isCheck(1)) {
                winner = 1;
                return true;
            }
        }
        return false;
    }

    public String getKing(int player) {
        if(player == 1) {
            return king1_x+","+king1_y;
        }
        else {
            return king2_x+","+king2_y;
        }
    }

    public int getWinner(){
        return winner;
    }

    /**
     * Checks whether the game is in stalemate
     * @return true if in stalemate, false otherwise
     */
    public boolean isStalemate() {
        return stalemate_count > 49;
    }

    public int getStalemate_count(){
        return stalemate_count;
    }

    /**
     * Increases stalemate count each turn
     */
    public void increaseStalemateCount() {
        stalemate_count++;
    }

    /**
     * If one of the players performed check, resets stalemate count
     */
    public void resetStalemateCount(){
        stalemate_count = 0;
    }

    /**
     * Helper functions that finds all the pieces of the player
     * @param b
     * @param player
     * @return ArrayList of string that contains all the pieces of the player
     */
    public ArrayList<String> findAllPieces(int[][] b, int player) {
        ArrayList<String> Pieces = new ArrayList<>();
        if(player == 1) {
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if(b[i][j] >= 10 && b[i][j] <=17) Pieces.add(b[i][j]+":"+i+","+j);
                }
            }
        }
        else {
            for(int i = 0; i < 8; i++) {
                for(int j = 0; j < 8; j++) {
                    if(b[i][j] >= 20 && b[i][j] <=27) Pieces.add(b[i][j]+":"+i+","+j);
                }
            }
        }
        return Pieces;
    }

    public boolean noPossibleKingMoves(int player) {
        if(player == 1) {
            Piece piece = new Piece(this.board, 11, king1_x, king1_y);
            ArrayList<String> moves = piece.move();
            for( String move : moves) {
                int x = Integer.parseInt(move.split(",")[0]);
                int y = Integer.parseInt(move.split(",")[1]);
            }
            return true;
        }
        else {
            Piece piece = new Piece(this.board, 21, king2_x, king2_y);
            ArrayList<String> moves = piece.move();
            return moves.size() == 0;
        }
    }

    public ArrayList<String> getDead() {
        return dead;
    }
}