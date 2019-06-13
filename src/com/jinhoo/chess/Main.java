package com.jinhoo.chess;

import com.jinhoo.chess.GUI.GUI;
import com.jinhoo.chess.main.Board;

import javax.swing.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

public class Main {
    public static void main(String[] args) {
        JFrame jFrame = new GUI();
        jFrame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        jFrame.pack();
        jFrame.setResizable(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}
