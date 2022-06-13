package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Game {
    private final int ROWS = 3;
    private final int COLS = 3;

    private char[][] board = new char[ROWS][COLS];
    private int xCount = 0;
    private int oCount = 0;
    private char winner = 0;
    private char currentTurn = 'X';

    public Game() {

        // Init empty board
        for (int i = 0; i < ROWS * COLS; i++) {

            int col = i % COLS;
            int row = i / ROWS;

            this.board[row][col] = ' ';
        }
    }

    public char getWinner() {
        return winner;
    }

    public void printBoard() {
        System.out.println("---------");
        for (int i = 0; i < this.board.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < this.board[i].length; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
    }

    public boolean isDraw() {
        return xCount + oCount == 9;
    }

    public void checkStatus() {

        // Check rows
        for (int i = 0; i < this.board.length; i++) {
            int rowSum = 0;
            for (int j = 0; j < this.board[i].length; j++) {
                rowSum += this.board[i][j];
            }

            processResult(rowSum);
        }

        // Check cols
        for (int i = 0; i < this.board[0].length; i++) {
            int colSum = 0;
            for (int j = 0; j < this.board.length; j++) {
                colSum += this.board[j][i];
            }
            processResult(colSum);
        }

        // Check diagonal
        int currentDiagonal = 0;
        currentDiagonal = board[0][0] + board[1][1] + board[2][2];
        processResult(currentDiagonal);

        currentDiagonal = board[2][0] + board[1][1] + board[0][2];
        processResult(currentDiagonal);
    }

    private void processResult(int result) {
        if (result == 264 || result == 237) {
            this.winner = (char) (result / 3);
        }
    }

    public void promptInput() {
        Scanner scanner = new Scanner(System.in);
        boolean inputIsValid = false;

        while (!inputIsValid) {
            System.out.print("Enter the coordinates: ");
            int row = 0;
            int col = 0;
            try {
                row = scanner.nextInt() - 1;
                col = scanner.nextInt() - 1;
            } catch (InputMismatchException e) {
                System.out.println("You should enter numbers!");
                continue;
            }

            if (row < 0 || row > 2 || col < 0 || col > 2) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }

            if (board[row][col] != ' ') {
                System.out.println("This cell is occupied! Choose another one!");
                continue;
            }

            board[row][col] = this.currentTurn;
            if (this.currentTurn == 'X') {
                this.currentTurn = 'O';
            } else {
                this.currentTurn = 'X';
            }
            inputIsValid = true;
        }
    }
}
