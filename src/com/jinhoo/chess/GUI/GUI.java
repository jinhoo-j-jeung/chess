package com.jinhoo.chess.GUI;

import com.jinhoo.chess.main.Board;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GUI extends JFrame implements MouseListener, MouseMotionListener{
    private JLayeredPane jLayeredPane;
    private JPanel board;
    private JLabel piece;
    private int xAdjustment;
    private int yAdjustment;
    /**
     * Default Constructor creating GUI for default chess game
     */
    public GUI(){
        // Initializes JLayeredPane;
        jLayeredPane = new JLayeredPane();
        getContentPane().add(jLayeredPane);
        jLayeredPane.setPreferredSize(new Dimension(600, 600));
        jLayeredPane.addMouseListener(this);
        jLayeredPane.addMouseMotionListener(this);

        // Initializes Chess Board
        board = new JPanel();
        jLayeredPane.add(board, JLayeredPane.DEFAULT_LAYER);
        board.setPreferredSize(new Dimension(600, 600));
        board.setLayout(new GridLayout(8, 8));
        board.setBounds(0, 0, 600, 600);

        // Sets the chess board;
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++) {
                JPanel tile = new JPanel(new BorderLayout());
                board.add(tile);
                if((i+j) % 2 == 0) {
                    tile.setBackground(Color.WHITE);
                }
                else {
                    tile.setBackground(Color.LIGHT_GRAY);
                }
            }
        }

        // Sets chess pieces on the board
        for(int i = 0; i < 64; i++) {
            JPanel tile = (JPanel) board.getComponent(i);
            piece = null;
            if (i == 0 || i == 7) {
                piece = new JLabel(new ImageIcon("chess_pieces/BR.gif"));
                piece.setName(Integer.toString(Board.ROOK_P1));
            } else if (i == 1 || i == 6) {
                piece = new JLabel(new ImageIcon("chess_pieces/BN.gif"));
                piece.setName(Integer.toString(Board.KNIGHT_P1));
            } else if (i == 2 || i == 5) {
                piece = new JLabel(new ImageIcon("chess_pieces/BB.gif"));
                piece.setName(Integer.toString(Board.BISHOP_P1));
            } else if (i == 4) {
                piece = new JLabel(new ImageIcon("chess_pieces/BK.gif"));
                piece.setName(Integer.toString(Board.KING_P1));
            } else if (i == 3) {
                piece = new JLabel(new ImageIcon("chess_pieces/BQ.gif"));
                piece.setName(Integer.toString(Board.QUEEN_P1));
            } else if (i >= 8 && i <= 15) {
                piece = new JLabel(new ImageIcon("chess_pieces/BP.gif"));
                piece.setName(Integer.toString(Board.PAWN_P1));
            } else if (i == 56 || i == 63) {
                piece = new JLabel(new ImageIcon("chess_pieces/WR.gif"));
                piece.setName(Integer.toString(Board.ROOK_P2));
            } else if (i == 57 || i == 62) {
                piece = new JLabel(new ImageIcon("chess_pieces/WN.gif"));
                piece.setName(Integer.toString(Board.KNIGHT_P2));
            } else if (i == 58 || i == 61) {
                piece = new JLabel(new ImageIcon("chess_pieces/WB.gif"));
                piece.setName(Integer.toString(Board.BISHOP_P2));
            } else if (i == 59) {
                piece = new JLabel(new ImageIcon("chess_pieces/WQ.gif"));
                piece.setName(Integer.toString(Board.QUEEN_P2));
            } else if (i == 60) {
                piece = new JLabel(new ImageIcon("chess_pieces/WK.gif"));
                piece.setName(Integer.toString(Board.KING_P2));
            } else if (i >= 48 && i <= 55) {
                piece = new JLabel(new ImageIcon("chess_pieces/WP.gif"));
                piece.setName(Integer.toString(Board.PAWN_P2));
            }
            if (piece != null) tile.add(piece);
        }
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {

    }

    /*
     * referred to https://forgetcode.com/Java/848-Chess-game-Swing
     */
    @Override
    public void mousePressed(MouseEvent e) {
        piece = null;
        Component c =  board.findComponentAt(e.getX(), e.getY());

        if (c instanceof JPanel)
            return;

        Point parentLocation = c.getParent().getLocation();
        xAdjustment = parentLocation.x - e.getX();
        yAdjustment = parentLocation.y - e.getY();
        piece = (JLabel)c;
        System.out.println(piece.getName());
        piece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
        piece.setSize(piece.getWidth(), piece.getHeight());
        jLayeredPane.add(piece, JLayeredPane.DRAG_LAYER);
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        if(piece == null) return;

        piece.setVisible(false);
        Component c =  board.findComponentAt(e.getX(), e.getY());

        if (c instanceof JLabel){
            Container parent = c.getParent();
            parent.remove(0);
            parent.add( piece );
        }
        else {
            Container parent = (Container)c;
            parent.add( piece );
        }

        piece.setVisible(true);
    }
    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
    @Override
    public void mouseDragged(MouseEvent e) {
        if (piece == null) return;
        piece.setLocation(e.getX() + xAdjustment, e.getY() + yAdjustment);
    }
    @Override
    public void mouseMoved(MouseEvent mouseEvent) {

    }
/*
    /**
     * Custom constructor creating GUI for the custom chess game
     * @param board
     */
/*
    public GUI(int[][] board) {
        this.jframe = new JFrame("Chess");
        this.jframe.setLayout(new BorderLayout());
        this.jframe.setSize(600, 600);

        this.jpanel = new JPanel(new GridLayout(8, 8));
        for(int i = 0; i < 8; i++){
            for(int j = 0; j < 8; j++) {
                Tile tile = new Tile(i, j);
                tile.setSize(20, 20);
                tile.setVisible(true);
                jpanel.add(tile);
                if((i+j) % 2 == 0) {
                    tile.setBackground(Color.WHITE);
                }
                else {
                    tile.setBackground(Color.LIGHT_GRAY);
                }
            }
        }

        for(int i = 0; i < 64; i++) {
            Tile tile = (Tile) jpanel.getComponent(i);
            int x = tile.getx();
            int y = tile.gety();
            JButton piece = null;
            if(board[x][y] != 0) {
                piece = tile.DrawPiece(board[x][y]);
            }
            if (piece != null) tile.add(piece);
        }
        jframe.add(jpanel, BorderLayout.CENTER);
        jframe.setVisible(true);
    }
*/
}