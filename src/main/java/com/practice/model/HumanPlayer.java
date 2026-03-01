package com.practice.model;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private String name;
    private Symbol symbolValue;
    private int score;
    private Scanner scanner;

    public HumanPlayer(String name, Symbol symbolValue, Scanner scanner) {
        this.name = name;
        this.symbolValue = symbolValue;
        this.score = 0;
        this.scanner = scanner;
    }

    @Override
    public int[] makeMove(Board board) {
        int[] position = new int[2];

        System.out.println(this.name + "- Indicate x position");
        position[0] = scanner.nextInt();
        System.out.println(this.name + "- Indicate y position");
        position[1] = scanner.nextInt();

        return position;
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
