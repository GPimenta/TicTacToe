package com.practice.model;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer extends  Player{
    private String name;
    private Symbol symbolValue;
    private int score;
    private Symbol oponentSymbolValue;

    public ComputerPlayer(Symbol symbolValue) {
        this.name = "Computer";
        this.symbolValue = symbolValue;
        this.score = 0;
        this.oponentSymbolValue = symbolValue == Symbol.X ? Symbol.O : Symbol.X;
    }

    @Override
    public int[] makeMove(Board board) {
        int[] move;

        move = findWinningMove(board);
        if (move != null) {
            return move;
        }

        move = findBlockingMove(board);
        if (move != null) {
            return move;
        }

        return findRandomMove(board);
    }

    private int[] findWinningMove(Board board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getSymbol(col, row) == Symbol.Empty) {
                    board.setSymbol(col, row, symbolValue);
                    if (board.hasWinner()) {
                        board.setSymbol(col, row, Symbol.Empty);
                        return new int[]{col, row};
                    } else {
                        board.setSymbol(col, row, Symbol.Empty);
                    }
                }
            }
        }
        return null;
    }

    private int[] findBlockingMove(Board board) {
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getSymbol(col, row) == Symbol.Empty) {
                    board.setSymbol(col, row, oponentSymbolValue);

                    if (board.hasWinner()) {
                        board.setSymbol(col, row, Symbol.Empty);
                        return new int[]{col, row};
                    } else {
                        board.setSymbol(col, row, Symbol.Empty);
                    }
                }
            }
        }
        return null;
    }

    private int[] findRandomMove(Board board) {
        List<int[]> list = new ArrayList<>();

        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 3; col++) {
                if (board.getSymbol(col, row) == Symbol.Empty) {
                    list.add(new int[]{col, row});
                }
            }
        }

        return list.get((int)(Math.random() * list.size()));
    }


    public String getName() { return name;}

    public void setName(String name) { this.name = name;}

    public Symbol getSymbolValue() {
        return symbolValue;
    }

    public void setSymbolValue(Symbol symbolValue) {
        this.symbolValue = symbolValue;
    }

    public int getScore() {
        return score;
    }

    public void addScore() {
        this.score++;
    }

    public void resetScore() {
        this.score = 0;
    }




}
