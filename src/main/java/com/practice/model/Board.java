package com.practice.model;

import java.util.Arrays;

public class Board {
    private Symbol[][] board;
    private int size;

    public Board(int size) {
        this.size = size;
        board = new Symbol[size][size];
        emptyBoard();
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
        if (x < 0 || x >= size || y < 0 || y >= size) {
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

    public boolean hasWinner() {
        //Rows
        for (int row = 0; row < getSize(); row++) {
            Symbol first = board[row][0];
            if (first == Symbol.Empty) {
                continue;
            }

            boolean win = true;
            for (int col = 1; col < size; col++) {
                if (board[row][col] != first) {
                    win = false;
                    break;
                }
            }
            if (win) {
                return true;
            }


        }

//        //Rows
//        for (int row = 0; row < 3; row++) {
//            if (board[row][0] != Symbol.Empty &&
//                    board[row][0] == board[row][1] &&
//                    board[row][1] == board[row][2]) {
//                return true;
//            }
//        }
        //Columns
        for (int col = 0; col < getSize(); col++) {
            Symbol first = board[0][col];
            if (first == Symbol.Empty) {
                continue;
            }

            boolean win = true;
            for (int row = 1; row < size; row++) {
                if (board[row][col] != first) {
                    win = false;
                    break;
                }
            }
            if (win) return true;
        }

//        //Columns
//        for (int col = 0; col < 3; col++) {
//            if (board[0][col] != Symbol.Empty &&
//                    board[0][col] == board[1][col] &&
//                    board[1][col] == board[2][col]) {
//                return true;
//            }
//        }



        //Right to left Diagonal
        Symbol firstDiag = board[0][0];
        if (firstDiag != Symbol.Empty) {
            boolean win = true;

            for (int i = 1; i < getSize(); i++) {
                if (board[i][i] != firstDiag) {
                    win = false;
                    break;
                }
            }
            if (win){
                return true;
            }
        }


//        if (board[0][0] != Symbol.Empty &&
//                board[0][0] == board[1][1] &&
//                board[1][1] == board[2][2]) {
//            return true;
//        }

        //Left to Right Diagonal
        Symbol firstAnti = board[0][size - 1];
        if (firstAnti != Symbol.Empty) {
            boolean win = true;

            for (int i = 1; i < size; i++) {
                if (board[i][size - 1 - i] != firstAnti) {
                    win = false;
                    break;
                }
            }

            if (win) return true;
        }

//        if (board[0][2] != Symbol.Empty &&
//                board[0][2] == board[1][1] &&
//                board[1][1] == board[2][0]) {
//            return true;
//        }

        return false;
    }

    public void reset() {
        for (int row = 0; row < getSize(); row++) {
            for (int col = 0; col < getSize(); col++) {
                setSymbol(row, col, Symbol.Empty);
            }
        }
        System.out.println("New Board");
    }

    public void printBoard() {
        StringBuilder xAxis = new StringBuilder();
        for (int i = 0; i < size; i++) {
            xAxis.append(" ").append(i);
        }
        System.out.println(xAxis.toString());
//        System.out.println("  0 1 2");
        for (int row = 0; row < getSize(); row++) {
            System.out.print(row + " ");
            for (int col = 0; col < getSize(); col++) {
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

    private void emptyBoard() {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[row].length; col++) {
                setSymbol(row, col, Symbol.Empty);
            }
        }
    }

    public Symbol getSymbol(int x, int y) {
        return board[y][x];
    }

    public void setSymbol(int x, int y, Symbol symbol) {
        board[y][x] = symbol;
    }

    public Symbol[][] getBoard() {
        return board;
    }

    public void setBoard(Symbol[][] board) {
        this.board = board;
    }

    public int getSize() {
        return  board.length;
    }

    @Override
    public String toString() {
        return "Board{" +
                "board=" + Arrays.toString(board) +
                '}';
    }
}
