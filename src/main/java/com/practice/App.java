package com.practice;

import com.practice.controller.Game;
import com.practice.model.*;

import java.util.Objects;
import java.util.Scanner;

public class App 
{
    public static void main( String[] args )
    {
        Scanner scanner = new Scanner(System.in);
        Board board = new Board();
        Game game;

        System.out.println("Play with Friend or Computer?");
        if (Objects.equals(scanner.nextLine(), "Friend")) {

            System.out.println("Enter name for Player 1 (X): ");
            String name1 = scanner.nextLine();
            System.out.println("Enter name for Player 2 (O): ");
            String name2 = scanner.nextLine();

            Player humanPlayer = new HumanPlayer(name1, Symbol.X, scanner);
            Player humanPlayer2 = new HumanPlayer(name2, Symbol.O, scanner);
            game = new Game(board, humanPlayer, humanPlayer2);
        } else {

            System.out.println("Enter name for Player 1 (X): ");
            String name1 = scanner.nextLine();

            Player humanPlayer = new HumanPlayer(name1, Symbol.X, scanner);
            Player computerPlayer = new ComputerPlayer(Symbol.O);
            game = new Game(board, humanPlayer, computerPlayer);

        }
        game.runGame();
    }
}
