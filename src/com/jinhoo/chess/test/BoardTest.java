package com.jinhoo.chess.test;

import com.jinhoo.chess.main.Board;
import org.junit.Test;

import java.io.*;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class BoardTest {
    @Test
    public void testDefaultBoardArrangement() {
        Board board = new Board();
        int[][] b = board.getBoard();
        int[][] ref = new int[8][8];
        // Pawn
        Arrays.fill(ref[1], 10);
        Arrays.fill(ref[6], 20);
        // Rock
        ref[0][0] = 13;
        ref[0][7] = 13;
        ref[7][0] = 23;
        ref[7][7] = 23;
        // Knight
        ref[0][1] = 14;
        ref[0][6] = 14;
        ref[7][1] = 24;
        ref[7][6] = 24;
        // Bishop
        ref[0][2] = 15;
        ref[0][5] = 15;
        ref[7][2] = 25;
        ref[7][5] = 25;
        // Queen
        ref[0][4] = 12;
        ref[7][3] = 22;
        // King
        ref[0][3] = 11;
        ref[7][4] = 21;

        for(int i = 0; i < 8; i++) {
            assertArrayEquals(ref[i], b[i]);
        }
    }

    @Test
    public void testCustomBoardArrangement(){
        int[][] ref = new int[8][8];
        ref[0][3] = 11;
        ref[7][3] = 21;
        ref[0][1] = 17;
        ref[7][7] = 26;
        ref[5][6] = 20;
        Board b = new Board(ref);

        for(int i = 0; i < 8; i++) {
            assertArrayEquals(ref[i], b.getBoard()[i]);
        }

        int[][] custom = new int[8][8];
        b = new Board(custom);
        assertNull(b.getBoard());
    }

    @Test
    public void testSelectPiece() {
        Board b = new Board();
        assertFalse(b.selectPiece(1, 8, 8));
        assertFalse(b.selectPiece(1, 7, 0));
        assertFalse(b.selectPiece(2, 1, 0));
        assertTrue(b.selectPiece(1, 1, 0));
        assertTrue(b.selectPiece(2, 7, 0));
    }

    @Test
    public void testGetPossibleLocations() {
        Board b = new Board();
        assertEquals(b.getPossibleLocations().size(),0);
        b.selectPiece(1, 1, 0);
        assertNotNull(b.getPossibleLocations());
    }

    @Test
    public void testMovePiece() {
        int[][] custom = new int[8][8];
        custom[0][3] = 11;
        custom[7][3] = 21;
        custom[1][0] = 10;
        custom[6][0] = 20;
        custom[0][0] = 13;

        Board b = new Board(custom);
        b.selectPiece(1, 1, 0);
        b.movePiece(1, 3, 0);
        assertEquals(b.getBoard()[3][0], 10);
        assertEquals(b.getBoard()[1][0], 0);

        b.selectPiece(1, 0, 3);
        b.movePiece(1, 0, 2);
        assertEquals(b.getKing(1), "0,2");

        b.selectPiece(2, 7, 3);
        b.movePiece(2, 7, 2);
        assertEquals(b.getKing(2), "7,2");

        b.selectPiece(1, 0, 0);
        b.movePiece(1, 6, 0);
        assertTrue(b.getDead().contains("2,20,6,0"));
    }

    @Test
    public void testFindAllPieces() {
        Board b = new Board();
        assertEquals(b.findAllPieces(b.getBoard(), 1).size(), 16);
        assertEquals(b.findAllPieces(b.getBoard(), 2).size(), 16);
    }

    @Test
    public void testCheck() {
        int[][] custom = new int[8][8];
        custom[0][3] = 11;
        custom[7][2] = 21;
        custom[1][0] = 13;
        custom[6][7] = 23;

        Board b = new Board(custom);

        b.selectPiece(1, 1, 0);
        b.movePiece(1, 1, 2);
        assertTrue(b.isCheck(1));
        b.selectPiece(2, 6, 7);
        b.movePiece(2, 6, 3);
        assertTrue(b.isCheck(2));
        b.selectPiece(1, 1, 2);
        b.movePiece(1, 1, 3);
        assertFalse(b.isCheck(1));
    }

    @Test
    public void testCheckmate() {
        int[][] custom = new int[8][8];
        custom[0][3] = 11;
        custom[7][2] = 21;
        custom[1][0] = 13;
        custom[6][7] = 23;

        Board b = new Board(custom);
        b.selectPiece(1, 1, 0);
        b.movePiece(1, 1, 2);
        b.isCheck(1);

        b.selectPiece(2, 6, 7);
        b.movePiece(2, 6, 6);
        b.isCheck(2);
        assertTrue(b.isCheckmate(2));

        b.selectPiece(1, 1, 2);
        b.movePiece(1, 1, 7);
        b.isCheck(1);
        b.selectPiece(2, 6, 6);
        b.movePiece(2, 6, 3);
        b.isCheck(2);
        assertFalse(b.isCheckmate(2));

        b.selectPiece(1, 1, 7);
        //b.movePiece(1, );
        b.movePiece(1, 1, 6);
        b.isCheck(1);
        assertTrue(b.isCheckmate(1));
        assertEquals(b.getWinner(), 2);
    }

    @Test
    public void testStalemate() {
        int[][] custom = new int[8][8];
        // King
        custom[0][3] = 11;
        custom[7][3] = 21;

        Board b = new Board(custom);
        for(int i = 1; i < 50; i++) {
            b.increaseStalemateCount();
            assertFalse(b.isStalemate());
            assertEquals(i, b.getStalemate_count());
        }
        b.increaseStalemateCount();
        assertTrue(b.isStalemate());
        b.resetStalemateCount();
        assertEquals(0, b.getStalemate_count());
    }

    @Test
    public void testPawnMovement() {
        int[][] custom1 = new int[8][8];
        custom1[0][3] = 11;
        custom1[7][4] = 21;

        custom1[1][0] = 10;
        custom1[2][1] = 10;
        custom1[2][5] = 10;
        custom1[3][4] = 20;
        custom1[3][6] = 20;

        Board b = new Board(custom1);

        b.selectPiece(1, 1, 0);
        assertEquals(b.getPossibleLocations().size(), 2);

        b.selectPiece(1, 2, 1);
        assertEquals(b.getPossibleLocations().size(), 1);

        b.selectPiece(1, 2, 5);
        assertEquals(b.getPossibleLocations().size(), 3);

        int[][] custom2 = new int[8][8];
        custom2[0][3] = 11;
        custom2[7][4] = 21;

        custom2[6][0] = 20;
        custom2[5][1] = 20;
        custom2[5][5] = 20;
        custom2[4][4] = 10;
        custom2[4][6] = 10;

        b = new Board(custom2);

        b.selectPiece(2, 6, 0);
        assertEquals(b.getPossibleLocations().size(), 2);

        b.selectPiece(2, 5, 1);
        assertEquals(b.getPossibleLocations().size(), 1);

        b.selectPiece(2, 5, 5);
        assertEquals(b.getPossibleLocations().size(), 3);
    }

    @Test
    public void testRockMovement() {

    }

    @Test
    public void testBishopMovement() {
        int[][] custom1 = new int[8][8];
        custom1[5][7] = 11;
        custom1[7][7] = 21;
        custom1[1][1] = 15;
        custom1[3][3] = 20;
        Board b = new Board(custom1);
        b.selectPiece(1, 1, 1);
        assertEquals(b.getPossibleLocations().size(), 5);

        int[][] custom2 = new int[8][8];
        custom2[5][7] = 11;
        custom2[7][7] = 21;
        custom2[1][1] = 25;
        custom2[3][3] = 10;
        b = new Board(custom2);
        b.selectPiece(2, 1, 1);
        assertEquals(b.getPossibleLocations().size(), 5);
    }

    @Test
    public void testKnightMovement() {
        int[][] custom1 = new int[8][8];
        custom1[0][7] = 11;
        custom1[7][7] = 21;
        custom1[3][3] = 14;
        custom1[5][4] = 10;
        custom1[5][2] = 10;
        custom1[1][4] = 20;
        custom1[1][2] = 20;

        Board b = new Board(custom1);
        b.selectPiece(1, 3, 3);
        assertEquals(b.getPossibleLocations().size(), 6);

        int[][] custom2 = new int[8][8];
        custom2[0][7] = 11;
        custom2[7][7] = 21;
        custom2[3][3] = 24;
        custom2[5][4] = 20;
        custom2[5][2] = 20;
        custom2[1][4] = 10;
        custom2[1][2] = 10;

        b = new Board(custom2);
        b.selectPiece(2, 3, 3);
        assertEquals(b.getPossibleLocations().size(), 6);
    }

    @Test
    public void testQueenMovement() {
        int[][] custom1 = new int[8][8];
        custom1[0][7] = 11;
        custom1[7][7] = 21;

        custom1[3][3] = 12;
        custom1[3][5] = 10;
        custom1[5][3] = 20;
        custom1[5][5] = 10;
        custom1[1][1] = 20;
        custom1[4][2] = 20;

        Board b = new Board(custom1);
        b.selectPiece(1, 3, 3);
        assertEquals(b.getPossibleLocations().size(), 16);

        int[][] custom2 = new int[8][8];
        custom2[0][7] = 11;
        custom2[7][7] = 21;

        custom2[3][3] = 22;
        custom2[3][5] = 20;
        custom2[5][3] = 10;
        custom2[5][5] = 20;
        custom2[1][1] = 10;
        custom2[4][2] = 10;

        b = new Board(custom2);
        b.selectPiece(2, 3, 3);
        assertEquals(b.getPossibleLocations().size(), 16);
    }

    @Test
    public void testKingMovement() {
        int[][] custom1 = new int[8][8];
        custom1[1][1] = 11;
        custom1[7][7] = 21;

        custom1[1][2] = 10;
        custom1[1][0] = 20;

        Board b = new Board(custom1);
        b.selectPiece(1, 1, 1);
        assertEquals(b.getPossibleLocations().size(), 7);

        int[][] custom2 = new int[8][8];
        custom2[1][1] = 21;
        custom2[7][7] = 11;

        custom2[1][2] = 20;
        custom2[1][0] = 10;

        b = new Board(custom2);
        b.selectPiece(2, 1, 1);
        assertEquals(b.getPossibleLocations().size(), 7);
    }

    @Test
    public void testDarkKnightMovement() {
        int[][] custom1 = new int[8][8];
        custom1[0][7] = 11;
        custom1[7][7] = 21;

        custom1[3][3] = 16;
        custom1[5][4] = 10;
        custom1[5][2] = 10;
        custom1[1][4] = 20;
        custom1[1][2] = 20;

        Board b = new Board(custom1);
        b.selectPiece(1, 3, 3);
        assertEquals(b.getPossibleLocations().size(), 8);

        int[][] custom2 = new int[8][8];
        custom2[0][7] = 11;
        custom2[7][7] = 21;

        custom2[3][3] = 26;
        custom2[5][4] = 10;
        custom2[5][2] = 10;
        custom2[1][4] = 20;
        custom2[1][2] = 20;

        b = new Board(custom2);
        b.selectPiece(2, 3, 3);
        assertEquals(b.getPossibleLocations().size(), 8);
    }

    @Test
    public void testRockAndRollMovement() {
        int[][] custom1 = new int[8][8];
        custom1[0][7] = 11;
        custom1[7][7] = 21;

        custom1[1][1] = 17;
        custom1[1][3] = 10;
        custom1[3][1] = 20;

        Board b = new Board(custom1);
        b.selectPiece(1, 1, 1);
        assertTrue(b.getPossibleLocations().size() >= 5);

        int[][] custom2 = new int[8][8];
        custom2[0][7] = 11;
        custom2[7][7] = 21;

        custom2[1][1] = 27;
        custom1[1][3] = 20;
        custom1[3][1] = 10;

        b = new Board(custom2);
        b.selectPiece(2, 1, 1);
        assertTrue(b.getPossibleLocations().size() >= 5);
    }

    @Test
    public void testNoPossibleKingMovement() {
        Board b = new Board();
        assertTrue(b.noPossibleKingMoves(1));
        assertTrue(b.noPossibleKingMoves(2));
    }

    @Test
    public void testPrintBoard() throws IOException {
        PrintStream old_out = System.out;
        System.setOut(new PrintStream(new FileOutputStream("print_output.txt")));

        Board b = new Board();
        b.printBoard();

        BufferedReader reader1 = new BufferedReader(new FileReader("/home/jinhoo/Desktop/CS242/fa18-cs242-assignment1.0/HW1.0/print_output.txt"));
        BufferedReader reader2 = new BufferedReader(new FileReader("/home/jinhoo/Desktop/CS242/fa18-cs242-assignment1.0/HW1.0/print_reference_output.txt"));

        String line1 = reader1.readLine();
        String line2 = reader2.readLine();
        while(line1 != null && line2 != null) {
            assertEquals(line1, line2);
            line1 = reader1.readLine();
            line2 = reader2.readLine();
        }
        assertNull(line1);
        assertNull(line2);

        reader1.close();
        reader2.close();

        System.setOut(old_out);
    }
}
