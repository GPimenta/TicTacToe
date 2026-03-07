package com.practice.model;

import java.util.ArrayList;
import java.util.List;

public class EasyStrategy implements MoveStrategy {
    @Override
    public int[] determineMove(Board board, Symbol symbolValue, Symbol opponentSymbolValue) {
        return findRandomMove(board);
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
}
