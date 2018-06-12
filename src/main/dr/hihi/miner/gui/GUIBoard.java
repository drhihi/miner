package main.dr.hihi.miner.gui;

import main.dr.hihi.miner.Board;
import main.dr.hihi.miner.Cell;

import javax.swing.*;
import java.awt.*;

public class GUIBoard extends JPanel implements Board {

    public static final int PADDING = 50;

    public Cell<Graphics>[][] cells;

    private boolean finishGame = false;
    private boolean victory = false;

    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        if (this.cells != null) {
            for (int x=0; x != this.cells.length; x++) {
                for (int y=0; y != this.cells[0].length; y++) {
                    graphics.setColor(Color.BLACK);
                    this.cells[x][y].draw(graphics, this.finishGame && !this.victory);
                    graphics.drawRect(x*PADDING, y*PADDING, PADDING, PADDING);
                }
            }
        }
    }

    @Override
    public void drawBoard(Cell[][] cells) {
        this.cells = cells;
        this.setStartGame();
        this.repaint();
    }

    @Override
    public void drawCell(int x, int y) {
        this.cells[x][y].draw(this.getGraphics(), this.finishGame && !this.victory);
    }

    @Override
    public void drawBang() {
        this.setFinishGame(false);
        this.repaint();
        JOptionPane.showMessageDialog(this.getRootPane(),"Miss", "Message", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void drawCongratulate() {
        this.setFinishGame(true);
        this.repaint();
        JOptionPane.showMessageDialog(this.getRootPane(),"Win");
    }

    private void setFinishGame(boolean victory) {
        this.victory = victory;
        this.finishGame = true;
    }

    private void setStartGame() {
        this.finishGame = false;
        this.victory = false;
    }

    public boolean isFinishGame() {
        return this.finishGame;
    }
}
