package com.practice.model;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer extends Player {
    private Symbol symbolValue;
    private final Symbol opponentSymbolValue;
    private MoveStrategy moveStrategy;

    public ComputerPlayer(Symbol symbolValue, Difficulty difficulty) {
        super("Computer", symbolValue);
        this.opponentSymbolValue = symbolValue == Symbol.X ? Symbol.O : Symbol.X;
        this.moveStrategy = createStrategy(difficulty);
    }

    @Override
    public int[] makeMove(Board board) {
        return moveStrategy.determineMove(board, symbolValue, opponentSymbolValue);
    }

    private MoveStrategy createStrategy(Difficulty difficulty) {
        switch (difficulty) {
            case EASY:
                return new EasyStrategy();
            case MEDIUM:
                return new MediumStrategy();
            default:
                return new HardStrategy();
        }
    }
}
