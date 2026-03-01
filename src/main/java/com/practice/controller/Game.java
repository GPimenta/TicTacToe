package com.practice.controller;

import com.practice.model.Board;
import com.practice.model.Player;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Board board, Player humanPlayer, Player computerPlayer) {
        this.board = board;
        this.player1 = humanPlayer;
        this.player2 = computerPlayer;
    }

    public void runGame() {
        System.out.println("Running game");
        Scanner scanner = new Scanner(System.in);

        currentPlayer = player1;

        while (true) {
            board.printBoard();
            int[] move;

            try {
                move = currentPlayer.makeMove(board);
            } catch (Exception e) {
                System.out.println(e);
                scanner.nextLine();
                continue;
            }

            if (!board.placeMove(move[0], move[1], currentPlayer.getSymbolValue())) {
                System.out.println("Play again");
                continue;
            }

            if (board.hasWinner()) {
                System.out.println(currentPlayer.getName() + " - Win the game");
                board.printBoard();
                return;
            } else if (board.isFull()) {
                System.out.println("It is a draw");
                board.printBoard();
                return;

            }

            if (currentPlayer == player1) {
                currentPlayer = player2;
            } else {
                currentPlayer = player1;
            }
        }
    }
}
