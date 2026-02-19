package com.practice.model;

public class Player {
    private String name;
    private Symbol symbolValue;
    private int score;

    public Player(String name, Symbol symbolValue) {
        this.name = name;
        this.symbolValue = symbolValue;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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
