package com.jinhoo.chess.test;

import com.jinhoo.chess.main.Board;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PieceTest {
    @Test
    public void testEmptySpaceMovement(){
        Board b = new Board();
        b.selectPiece(1, 1, 0);
        int selected_piece = b.getBoard()[1][0];
        ArrayList<String> possibleSpaces = b.getPossibleLocations();
        for(int i = 0; i < possibleSpaces.size(); i++) {
            String input = possibleSpaces.get(i);
            int x = Integer.parseInt(input.split(",")[0]);
            int y = Integer.parseInt(input.split(",")[1]);
            assertEquals(b.getBoard()[x][y], 0);
        }
        String input = possibleSpaces.get(0);
        int x = Integer.parseInt(input.split(",")[0]);
        int y = Integer.parseInt(input.split(",")[1]);
        b.movePiece(1, x, y);
        assertEquals(selected_piece, b.getBoard()[x][y]);
        assertEquals(b.getBoard()[1][0], 0);
    }

    @Test
    public void testCaptureMovement() {
        int[][] ref = new int[8][8];
        // King
        ref[0][3] = 11;
        ref[7][3] = 21;

        // Rock
        ref[0][0] = 17;

        // Pawn
        ref[6][0] = 20;

        Board b = new Board(ref);
        b.selectPiece(1, 0, 0);
        b.movePiece(1, 6, 0);

        assertEquals(17, b.getBoard()[6][0]);
        assertEquals(0, b.getBoard()[0][0]);

        String dead_info = b.getDead().get(0);
        assertEquals("2,20,6,0", dead_info);
    }

    @Test
    public void testInvalidMovement() {
        Board b = new Board();

        Arrays.fill(b.getBoard()[1], 0);
        Arrays.fill(b.getBoard()[6], 0);
        for(int i = 0; i < 8; i++) {
            b.selectPiece(1, 0, i);
            ArrayList<String> possibleLocations = b.getPossibleLocations();
            for(int j = 0; j < possibleLocations.size(); j++) {
                if(possibleLocations.size() != 0) {
                    String input = possibleLocations.get(j);
                    int x = Integer.parseInt(input.split(",")[0]);
                    int y = Integer.parseInt(input.split(",")[1]);
                    assert ((x >= 0 && x <= 7) && (y >= 0 && y <= 7));
                }
            }
        }
        for(int i = 0; i < 8; i++) {
            b.selectPiece(2, 7, i);
            ArrayList<String> possibleLocations = b.getPossibleLocations();
            for(int j = 0; j < possibleLocations.size(); j++) {
                if(possibleLocations.size() != 0) {
                    String input = possibleLocations.get(j);
                    int x = Integer.parseInt(input.split(",")[0]);
                    int y = Integer.parseInt(input.split(",")[1]);
                    assert ((x >= 0 && x <= 7) && (y >= 0 && y <= 7));
                }
            }
        }
        Arrays.fill(b.getBoard()[1], 10);
        Arrays.fill(b.getBoard()[6], 20);
        for(int i = 0; i < 8; i++) {
            b.selectPiece(1, 1, i);
            ArrayList<String> possibleLocations = b.getPossibleLocations();
            for(int j = 0; j < possibleLocations.size(); j++) {
                if(possibleLocations.size() != 0) {
                    String input = possibleLocations.get(j);
                    int x = Integer.parseInt(input.split(",")[0]);
                    int y = Integer.parseInt(input.split(",")[1]);
                    assert ((x >= 0 && x <= 7) && (y >= 0 && y <= 7));
                }
            }
        }
        for(int i = 0; i < 8; i++) {
            b.selectPiece(2, 6, i);
            ArrayList<String> possibleLocations = b.getPossibleLocations();
            for(int j = 0; j < possibleLocations.size(); j++) {
                if(possibleLocations.size() != 0) {
                    String input = possibleLocations.get(j);
                    int x = Integer.parseInt(input.split(",")[0]);
                    int y = Integer.parseInt(input.split(",")[1]);
                    assert ((x >= 0 && x <= 7) && (y >= 0 && y <= 7));
                }
            }
        }

        int[][] custom = new int[8][8];

        // King
        custom[0][2] = 11;
        custom[7][5] = 21;

        // Rock_and_Roll
        custom[0][0] = 17;
        custom[7][7] = 27;

        // Dark_Knight
        custom[0][1] = 16;
        custom[7][6] = 26;

        b = new Board(custom);
        for(int i = 0; i < 3; i++) {
            b.selectPiece(1, 0, i);
            ArrayList<String> possibleLocations = b.getPossibleLocations();
            for(int j = 0; j < possibleLocations.size(); j++) {
                if(possibleLocations.size() != 0) {
                    String input = possibleLocations.get(j);
                    int x = Integer.parseInt(input.split(",")[0]);
                    int y = Integer.parseInt(input.split(",")[1]);
                    assert ((x >= 0 && x <= 7) && (y >= 0 && y <= 7));
                }
            }
        }
        for(int i = 5; i < 8; i++) {
            b.selectPiece(2, 7, i);
            ArrayList<String> possibleLocations = b.getPossibleLocations();
            for(int j = 0; j < possibleLocations.size(); j++) {
                if(possibleLocations.size() != 0) {
                    String input = possibleLocations.get(j);
                    int x = Integer.parseInt(input.split(",")[0]);
                    int y = Integer.parseInt(input.split(",")[1]);
                    assert ((x >= 0 && x <= 7) && (y >= 0 && y <= 7));
                }
            }
        }
    }

}
