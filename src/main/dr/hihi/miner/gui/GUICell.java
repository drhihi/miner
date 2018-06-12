package main.dr.hihi.miner.gui;

import main.dr.hihi.miner.Cell;

import java.awt.*;

public class GUICell implements Cell<Graphics> {
    private boolean bomb;
    private boolean suggestBomb = false;
    private boolean suggestEmpty = false;
    private int x, y;

    public GUICell(boolean bomb, int x, int y) {
        this.bomb = bomb;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean isBomb() {
        return this.bomb;
    }

    @Override
    public boolean isSuggestBomb() {
        return this.suggestBomb;
    }

    @Override
    public boolean isSuggestEmpty() {
        return this.suggestEmpty;
    }

    @Override
    public void suggestEmpty() {
        this.suggestEmpty = true;
    }

    @Override
    public void suggestBomb() {
        this.suggestBomb = true;
    }

    @Override
    public void draw(Graphics paint, boolean real) {
        final Color color = paint.getColor();
        if (real) {
            if (this.isBomb()) {
                paint.setColor(Color.MAGENTA);
            } else {
                paint.setColor(Color.WHITE);
            }
        } else {
            if (this.suggestBomb) {
                paint.setColor(Color.RED);
            } else if (this.suggestEmpty) {
                paint.setColor(Color.WHITE);
            } else {
                paint.setColor(Color.GREEN);
            }
        }
        paint.fillOval(
                this.x * GUIBoard.PADDING + 10,
                this.y * GUIBoard.PADDING + 10,
                GUIBoard.PADDING - 20,
                GUIBoard.PADDING - 20
        );
        paint.setColor(color);
    }
}
