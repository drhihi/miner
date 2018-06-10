package main.dr.hihi.miner.gui;

import main.dr.hihi.miner.Cell;
import main.dr.hihi.miner.GeneratorBoard;
import main.dr.hihi.miner.logics.Easy;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class GUIMain {
    private static final JPanel controlPanel = new JPanel();
    private static final GUIBoard board = new GUIBoard();

    public static void main(String[] arg) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                final JFrame frame = new JFrame();
                frame.setTitle("miner");
                frame.setLayout(new BorderLayout());
                frame.setSize(GUIBoard.PADDING * 10, GUIBoard.PADDING * 10);
                frame.add(board, BorderLayout.CENTER);
                board.setBorder(new EmptyBorder(10, 10, 10, 10));
                frame.add(controlPanel, BorderLayout.PAGE_END);
                controlPanel.setLayout(new FlowLayout());
                final JButton generate = new JButton("start");
                generate.addActionListener(
                        new GUIAction(
                                new Easy(), board,
                                new GeneratorBoard() {
                                    public Cell[][] generate() {
                                        return new Cell[][] {{new GUICell(), new GUICell()}, {new GUICell(), new GUICell()}};
                                    }
                                }
                        )
                );
                controlPanel.add(generate);
                center(frame);
                frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
                frame.addWindowListener(new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent windowEvent) {
                        closePerform(frame);
                    }
                });
                frame.setVisible(true);
            }
        });
    }

    public static void center(Window w){
        Dimension us = w.getSize();
        Dimension them = Toolkit.getDefaultToolkit().getScreenSize();
        int newX = (them.width - us.width) / 2;
        int newY = (them.height - us.height) / 2;
        w.setLocation(newX, newY);
    }

    public static void closePerform(JFrame frame){
        frame.setVisible(false);
        frame.dispose();
        System.exit(0);
    }
}
