package main.dr.hihi.miner.gui;

import main.dr.hihi.miner.BaseAction;
import main.dr.hihi.miner.GeneratorBoard;
import main.dr.hihi.miner.SaperLogic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GUIAction extends BaseAction implements ActionListener, MouseListener {
    private GUIBoard board;

    public GUIAction(SaperLogic logic, GUIBoard board, GeneratorBoard generator){
        super(logic, board, generator);
        this.board = board;
        this.board.addMouseListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        this.initGame();
    }

    @Override
    public void mouseClicked(MouseEvent mouseEvent) {
        board.repaint();
    }

    @Override
    public void mousePressed(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseReleased(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseEntered(MouseEvent mouseEvent) {

    }

    @Override
    public void mouseExited(MouseEvent mouseEvent) {

    }
}
