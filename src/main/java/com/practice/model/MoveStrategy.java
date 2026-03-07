package com.practice.model;

public interface MoveStrategy {
    public int[] determineMove(Board board, Symbol symbolValue, Symbol opponentSymbolValue);
}
