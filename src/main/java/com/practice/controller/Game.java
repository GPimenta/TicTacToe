package com.practice.controller;

import com.practice.model.Board;
import com.practice.model.Player;

import java.util.Scanner;

public class Game {
    private Board board;
    private Player player1;
    private Player player2;
    private Player currentPlayer;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        this.player1 = player1;
        this.player2 = player2;
    }

    public void runGame() {
        Scanner scanner = new Scanner(System.in);
        String playAgain;

        do {
            playMatch();
            boardScore();

            System.out.println("Want to play again? y/n");
            playAgain = scanner.nextLine();
            board.reset();

        } while (playAgain.equalsIgnoreCase("y"));

    }

    public void playMatch() {
        System.out.println("Running game");

        currentPlayer = player1;

        while (true) {
            board.printBoard();
            int[] move;

            try {
                move = currentPlayer.makeMove(board);
            } catch (Exception e) {
                System.out.println(e);
                continue;
            }

            if (!board.placeMove(move[0], move[1], currentPlayer.getSymbolValue())) {
                System.out.println("Play again");
                continue;
            }

            if (board.hasWinner()) {
                System.out.println(currentPlayer.getName() + " - Win the game");
                currentPlayer.addScore();
                board.printBoard();
                return;
            } else if (board.isFull()) {
                System.out.println("It is a draw");
                board.printBoard();
                return;

            }
            switchPlayer();
        }
    }

    private void boardScore() {
        System.out.println("Score:");
        System.out.println(player1.getName()+" -> "+player1.getScore());
        System.out.println(player2.getName()+" -> "+player2.getScore());
    }

    private void switchPlayer() {
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
    }
}
