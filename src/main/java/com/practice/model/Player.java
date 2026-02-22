package com.practice.model;

public abstract class Player {
    public abstract int[] makeMove(Board board);
    public abstract String getName();
    public abstract  void setName(String name);
    public abstract Symbol getSymbolValue();
    public abstract void setSymbolValue(Symbol symbolValue);
    public abstract int getScore();
    public abstract void addScore();
    public abstract void resetScore();
}
