package com.practice.model;

import java.util.Scanner;

public class HumanPlayer extends Player {
    private Scanner scanner;

    public HumanPlayer(String name, Symbol symbolValue, Scanner scanner) {
        super(name,symbolValue);
        this.scanner = scanner;
    }

    @Override
    public int[] makeMove(Board board) {
        int[] position = new int[2];

        scanner.nextLine();
        System.out.println(super.getName() + " - Indicate x position");
        position[0] = scanner.nextInt();
        System.out.println(this.getName() + " - Indicate y position");
        position[1] = scanner.nextInt();
        scanner.nextLine();

        return position;
    }
}
