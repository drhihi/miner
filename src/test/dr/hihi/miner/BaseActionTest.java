package test.dr.hihi.miner;

import main.dr.hihi.miner.BaseAction;
import main.dr.hihi.miner.Cell;
import main.dr.hihi.miner.GeneratorBoard;
import main.dr.hihi.miner.console.ConsoleBoard;
import main.dr.hihi.miner.console.ConsoleCell;
import main.dr.hihi.miner.logics.Easy;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class BaseActionTest {
    final BaseAction action = new BaseAction(
            new Easy(), new ConsoleBoard(),
            new GeneratorBoard() {
                @Override
                public Cell[][] generate() {
                    return new Cell[][] {
                            {new ConsoleCell(true), new ConsoleCell(false)},
                            {new ConsoleCell(true), new ConsoleCell(false)}};
                }
            }
    );

    @Test
    public void successGame() {
        action.initGame();
        action.select(0, 0, true);
        action.select(1, 0, true);
        action.select(0, 1, false);
        action.select(1, 1, false);
    }

    @Test
    public void failureGame() {
        action.initGame();
        action.select(0, 0, true);
        action.select(1, 0, false);
    }


}