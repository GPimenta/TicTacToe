package com.practice.model;

import java.util.Arrays;

public class Board {
    private Symbol[][] board = new Symbol[3][3];

    public Board() {
        board[0] = new Symbol[]{Symbol.Empty, Symbol.Empty, Symbol.Empty};
        board[1] = new Symbol[] {Symbol.Empty, Symbol.Empty, Symbol.Empty};
        board[2] = new Symbol[] {Symbol.Empty, Symbol.Empty, Symbol.Empty};
    }

    public Symbol[][] getBoard() {
        return board;
    }

    public void setBoard(Symbol[][] board) {
        this.board = board;
    }

    public boolean placeMove(int x, int y, Symbol value) {
        if (!isFull() && checkIfPositionValid(x, y)) {
            this.board[y][x] = value;
            return true;
        } else {
            return false;
        }
    }

    private boolean checkIfPositionValid(int x, int y) {
        if (x < 0 || x >= 3 || y < 0 || y >= 3) {
            System.out.println("Position outbound");
            return false;
        }
        if (this.board[y][x] != Symbol.Empty) {
            System.out.println("Position is already occupied");
            return false;
        }
        return true;
    }

    public boolean isFull() {
        for (Symbol[] symbols : board) {
            if (Arrays.stream(symbols).anyMatch(symbol -> symbol == Symbol.Empty)) {
                return false;
            }
        }
        return true;
    }


    public void printBoard() {
        System.out.println("  0 1 2");
        for (int row = 0; row < 3; row++) {
            System.out.print(row + " ");
            for (int col = 0; col < 3; col++) {
                Symbol symbol = board[row][col];
                if (symbol == Symbol.Empty) {
                    System.out.print("  ");
                } else {
                    System.out.print(symbol + " ");
                }
            }
            System.out.println();
        }
    }


    public boolean hasWinner() {
        //Rows
        for (int row = 0; row < 3; row++) {
            if (board[row][0] != Symbol.Empty &&
                    board[row][0] == board[row][1] &&
                    board[row][1] == board[row][2]) {
                return true;
            }
        }
        //Columns
        for (int col = 0; col < 3; col++) {
            if (board[0][col] != Symbol.Empty &&
                    board[0][col] == board[1][col] &&
                    board[1][col] == board[2][col]) {
                return true;
            }
        }
        //Right to left Diagonal
        if (board[0][0] != Symbol.Empty &&
                board[0][0] == board[1][1] &&
                board[1][1] == board[2][2]) {
            return true;
        }
        //Left to Right Diagonal
        if (board[0][2] != Symbol.Empty &&
                board[0][2] == board[1][1] &&
                board[1][1] == board[2][0]) {
            return true;
        }

        return false;
    }


    public Symbol getSymbol(int x, int y) {
        return board[y][x];
    }

    public void setSymbol(int x, int y, Symbol symbol) {
        board[y][x] = symbol;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
