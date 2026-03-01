package com.practice.model;

import java.util.ArrayList;
import java.util.List;

public class ComputerPlayer extends Player {
    private String name;
    private Symbol symbolValue;
    private int score;
    private final Symbol opponentSymbolValue;
    private final Difficulty difficulty;

    public ComputerPlayer(Symbol symbolValue, Difficulty difficulty) {
        this.name = "Computer";
        this.symbolValue = symbolValue;
        this.score = 0;
        this.opponentSymbolValue = symbolValue == Symbol.X ? Symbol.O : Symbol.X;
        this.difficulty = difficulty;
    }

    @Override
    public int[] makeMove(Board board) {
        int[] move;

        if (difficulty == Difficulty.EASY) {
//            System.out.println("Running Easy");
            return findRandomMove(board);
        }

        if (difficulty == Difficulty.MEDIUM) {
            System.out.println("Running Medium");
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

        System.out.println("Running Hard");
        move = findWinningMove(board);
        if (move != null) {
            return move;
        }

        move = findBlockingMove(board);
        if (move != null) {
            return move;
        }

        move = takeCentre(board);
        if (move != null) {
            return move;
        }

        move = takeCorners(board);
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
                    board.setSymbol(col, row, opponentSymbolValue);

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

    private int[] takeCentre(Board board) {
        if (board.getSymbol(1,1) == Symbol.Empty) {
            return new int[]{1, 1};
        }
        return null;
    }

    private int[] takeCorners(Board board) {
        List<int[]> list = new ArrayList<>();

        list.add(new int[]{0,0});
        list.add(new int[]{0,2});
        list.add(new int[]{2,0});
        list.add(new int[]{2,2});

        for (int[] corner : list) {
            if (board.getSymbol(corner[0], corner[1]) == Symbol.Empty) {
                return corner;
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
