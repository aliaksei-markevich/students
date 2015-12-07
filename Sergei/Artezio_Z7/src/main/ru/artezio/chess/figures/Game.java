package ru.artezio.chess.figures;

import java.util.Scanner;

/**
 * Класс реализующий саму игру
 */
public class Game {

    public static void main(String[] args) {

        String command = " ";
        Scanner sc = new Scanner(System.in);
        Board board = new Board();
        GameController game = new GameController();
        game.PlaceFigures(board);
        game.setColorPlayer(Color.White);
        while ((!command.equals("exit")) &&
                (game.getColorPlayerVictory() == null)) {
            board.PrintBoard();
            game.printWhoMove();
            game.threatenKing(board, false);
            command = game.insertMove();
            if ((!game.checkCommand(command, board))) {
                continue;
            }
            game.replaceFigure(new Move(command), board);
            game.nextColor();
            game.notKing(board);
        }
        game.checkVictory();
        System.out.println("Игра закончена");
    }
}
