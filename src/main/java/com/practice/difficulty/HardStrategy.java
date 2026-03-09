package com.practice.difficulty;

import com.practice.model.Board;
import com.practice.model.MoveStrategy;
import com.practice.model.Symbol;

import java.util.ArrayList;
import java.util.List;

public class HardStrategy implements MoveStrategy {
    @Override
    public int[] determineMove(Board board, Symbol symbolValue, Symbol opponentSymbolValue) {
        int[] move;

        System.out.println("Running Hard");
        move = findWinningMove(board, symbolValue);
        if (move != null) {
            return move;
        }

        move = findBlockingMove(board, opponentSymbolValue);
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

    private int[] findWinningMove(Board board, Symbol symbolValue) {
        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
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

    private int[] findBlockingMove(Board board, Symbol opponentSymbolValue) {
        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
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

    private int[] findRandomMove(Board board) {
        List<int[]> list = new ArrayList<>();

        for (int row = 0; row < board.getSize(); row++) {
            for (int col = 0; col < board.getSize(); col++) {
                if (board.getSymbol(col, row) == Symbol.Empty) {
                    list.add(new int[]{col, row});
                }
            }
        }
        return list.get((int)(Math.random() * list.size()));
    }

    private int[] takeCentre(Board board) {
        int centre = board.getSize()/2;

        if (board.getSymbol(centre,centre) == Symbol.Empty) {
            return new int[]{centre, centre};
        }
        return null;
    }

    private int[] takeCorners(Board board) {
        List<int[]> list = new ArrayList<>();
        int max = board.getSize() - 1;

        list.add(new int[]{0,0});
        list.add(new int[]{0, max});
        list.add(new int[]{max,0});
        list.add(new int[]{max, max});

        for (int[] corner : list) {
            if (board.getSymbol(corner[0], corner[1]) == Symbol.Empty) {
                return corner;
            }
        }
        return null;
    }
}
