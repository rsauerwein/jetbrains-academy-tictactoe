package tictactoe;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Game game = new Game();
        while (game.getWinner() == 0 && !game.isDraw()) {
            game.printBoard();
            game.promptInput();
            game.checkStatus();
        }

        game.printBoard();

        if (game.isDraw()) {
            System.out.println("Draw");
        } else {
            System.out.println(game.getWinner() + " wins");
        }
    }
}
