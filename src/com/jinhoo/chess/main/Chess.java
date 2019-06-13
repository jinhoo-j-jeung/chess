package com.jinhoo.chess.main;

import java.util.ArrayList;
import java.util.Scanner;

public class Chess {
    public static void main(String[] args) {
        //Board board = new Board();

        int[][] custom = new int[8][8];
        custom[0][3] = 11;
        custom[0][0] = 13;
        custom[1][2] = 10;
        custom[7][4] = 21;
        custom[7][7] = 23;
        custom[6][0] = 20;
        Board board = new Board(custom);

        board.printBoard();

        Scanner scanner = new Scanner(System.in);
        ArrayList<String> nextPosLocs;
        // The game starts with the player 1
        int player = 1;
        while (true) {
            // Player selects the piece
            System.out.println("Select your piece, Player " + player + "! (Type x,y location.)");
            String input = scanner.nextLine();
            while (!input.contains(",")) {
                System.out.println("Invalid input!");
                System.out.println("Select your piece, Player " + player + "! (Type x,y location.)");
                input = scanner.nextLine();
            }
            int x = Integer.parseInt(input.split(",")[0]);
            int y = Integer.parseInt(input.split(",")[1]);
            while (!board.selectPiece(player, x, y)) {
                System.out.println("Invalid input!");
                System.out.println("Select your piece, Player " + player + "! (Type x,y location.)");
                input = scanner.nextLine();
                x = Integer.parseInt(input.split(",")[0]);
                y = Integer.parseInt(input.split(",")[1]);
            }
            // Possible locations to which the selected piece can move get displayed
            nextPosLocs = board.getPossibleLocations();
            System.out.println("Possible locations are: ");
            for (int i = 0; i < nextPosLocs.size(); i++) System.out.print(nextPosLocs.get(i) + "; ");
            System.out.println();
            // Player chooses one of the given possible locations
            System.out.println("Choose the location! (Type x,y location.)");
            input = scanner.nextLine();
            while (!nextPosLocs.contains(input)) {
                System.out.println("Invalid input!");
                System.out.println("Choose the location! (Type x,y location.)");
                input = scanner.nextLine();
            }
            // Moves the piece to the chosen location
            x = Integer.parseInt(input.split(",")[0]);
            y = Integer.parseInt(input.split(",")[1]);
            board.movePiece(player, x, y);
            // Checks if the opponent's king is captured
            if (board.getWinner() != -1) {
                System.out.println("Winner is Player " + board.getWinner());
                break;
            }
            // Checks whether the opponent is checked
            if (board.isCheck(player)) {
                System.out.println("Check!");
                board.resetStalemateCount();
            }
            // Checks whether the player made a suicide move
            else if (board.isCheck(player % 2 + 1)) {
                System.out.println("Checkmate");
                if (player % 2 + 1 == 1) System.out.println("Winner is Player 1");
                else System.out.println("Winner is Player 2");
                break;
            }
            // If checking did not happen, increments stalemate count
            else {
                board.increaseStalemateCount();
                System.out.println("Stalemate count is " + board.getStalemate_count());
            }
            // Checks if there is a checkmate
            if (board.isCheckmate(player)) {
                System.out.println("Checkmate!");
                System.out.println("Winner is Player " + board.getWinner());
                break;
            }
            // Checks if the game is in stalemate
            if (board.isStalemate()) {
                System.out.println("Draw!");
                break;
            }
            board.printBoard();
            player = player % 2 + 1;
        }
    }
}