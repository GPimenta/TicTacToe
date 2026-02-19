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
        if (isNotFull() && checkIfPositionValid(x, y)) {
            this.board[y][x] = value;
            return true;
        } else {
            return false;
        }
    }

    private boolean checkIfPositionValid(int x, int y) {
        if (x >= 3 || y >= 3) {
            System.out.println("Position outbound");
            return false;
        }
        if (this.board[y][x] != Symbol.Empty) {
            System.out.println("Position is already occupied");
            return false;
        }
        return true;
    }

    public boolean isNotFull() {
        for (Symbol[] symbols : board) {
            if (Arrays.stream(symbols).anyMatch(symbol -> symbol == Symbol.Empty)) {
                return true;
            }
        }
        return false;
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
        if (board[0][0] != Symbol.Empty && board[0][0] == board[0][1] && board[0][1] == board[0][2]) {
            return true;
        } else if(board[1][0] != Symbol.Empty && board[1][0] == board[1][1] && board[1][1] == board[1][2]) {
            return true;
        } else if (board[2][0] != Symbol.Empty && board[2][0] == board[2][1] && board[2][1] == board[2][2]) {
            return true;
        }
        // Columns
        if (board[0][0] != Symbol.Empty && board[0][0] == board[1][0] && board[1][0] == board[2][0]) {
            return true;
        } else if (board[0][1] != Symbol.Empty && board[0][1] == board[1][1] && board[1][1] == board[2][1]) {
            return true;
        } else if (board[0][2] != Symbol.Empty && board[0][2] == board[1][2] && board[1][2] == board[2][2]) {
            return true;
        }
        //Diagonal
        if (board[0][0] != Symbol.Empty && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
            return true;
        } else if (board[0][2] != Symbol.Empty && board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
            return true;
        }
        return false;
    }

    public Symbol getSymbol(int x, int y) {
        return board[y][x];
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
