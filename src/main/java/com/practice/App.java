package com.practice;

import com.practice.controller.Game;
import com.practice.model.Board;
import com.practice.model.HumanPlayer;
import com.practice.model.Symbol;

import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter name for Player 1 (X): ");
        String name1 = scanner.nextLine();

        System.out.println("Enter name for Player 2 (O): ");
        String name2 = scanner.nextLine();

        HumanPlayer humanPlayer1 = new HumanPlayer(name1, Symbol.X);
        HumanPlayer humanPlayer2 = new HumanPlayer(name2, Symbol.O);

        Board board = new Board();

        Game game = new Game(board, humanPlayer1, humanPlayer2);

        game.runGame();
    }
}
