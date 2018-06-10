package main.dr.hihi.miner.gui;

import main.dr.hihi.miner.Board;
import main.dr.hihi.miner.Cell;

import javax.swing.*;
import java.awt.*;

public class GUIBoard extends JPanel implements Board {

    public static final int PADDING = 50;

    public Cell<Graphics>[][] cells;

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (this.cells != null) {
            for (int x=0; x != cells.length; x++) {
                for (int y=0; y !=cells[0].length; y++) {
                    graphics.setColor(Color.BLACK);
                    cells[x][y].draw(graphics, false);
                    graphics.drawRect(x*PADDING, y*PADDING, PADDING, PADDING);
                }
            }
        }
    }

    @Override
    public void drawBoard(Cell[][] cells) {
        this.cells = cells;
        this.repaint();
    }

    @Override
    public void drawCell(int x, int y) {
        this.repaint();
    }

    @Override
    public void drawBang() {
        this.repaint();
    }

    @Override
    public void drawCongratulate() {

    }
}
