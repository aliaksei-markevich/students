package ru.artezio.chess.figures;

import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * Класс реализующий взаимодействие пользователя с щахматной доской
 */
public class GameController {

    private static final int SIZE_CHESS = 8;
    /**
     * Поля отвечающие за харнения цвета игрока и цвета игрока победителя
     */
    private Color colorPlayer;
    private ColorVictory colorPlayerVictory = null;

    public ColorVictory getColorPlayerVictory() {
        return colorPlayerVictory;
    }

    public void setColorPlayer(Color colorPlayer) {
        this.colorPlayer = colorPlayer;
    }

    public Color getColorPlayer() {
        return colorPlayer;
    }

    /**
     * Метод расставляет фигуры
     *
     * @param board шахматная доска
     */
    public void PlaceFigures(Board board) {
        for (int i = 0; i < SIZE_CHESS; i++) {
            Pawn p = new Pawn(Color.White);
            board.addFigure(p, i, 1);

            p = new Pawn(Color.Black);
            board.addFigure(p, i, 6);
        }


        Rook r = new Rook(Color.White);// добавлена ладья
        board.addFigure(r, 0, 0);
        r = new Rook(Color.White);
        board.addFigure(r, 7, 0);
        r = new Rook(Color.Black);
        board.addFigure(r, 0, 7);
        r = new Rook(Color.Black);
        board.addFigure(r, 7, 7);

        Bishop b = new Bishop(Color.White);// добавлен слон
        board.addFigure(b, 2, 0);
        b = new Bishop(Color.White);
        board.addFigure(b, 5, 0);
        b = new Bishop(Color.Black);
        board.addFigure(b, 2, 7);
        b = new Bishop(Color.Black);
        board.addFigure(b, 5, 7);

        Knight k = new Knight(Color.White);// добавлена коников
        board.addFigure(k, 1, 0);
        k = new Knight(Color.White);
        board.addFigure(k, 6, 0);
        k = new Knight(Color.Black);
        board.addFigure(k, 1, 7);
        k = new Knight(Color.Black);
        board.addFigure(k, 6, 7);

        King king = new King(Color.White);// добавлена королей
        board.addFigure(king, 4, 0);
        king = new King(Color.Black);
        board.addFigure(king, 4, 7);

        Queen q = new Queen(Color.White);// добавлена ферзей
        board.addFigure(q, 3, 0);
        q = new Queen(Color.Black);
        board.addFigure(q, 3, 7);

    }

    /**
     * Ввод скоманды
     *
     * @return команду строку
     */
    public String insertMove() {
        System.out.println("Введите свой ход");
        return (new Scanner(System.in)).nextLine();
    }

    /**
     * Меняет цвет игрока
     */
    public void nextColor() {
        if (getColorPlayer() == Color.White) {
            setColorPlayer(Color.Black);
        } else {
            setColorPlayer(Color.White);
        }
    }

    /**
     * Пересталяет фигуру
     *
     * @param move  координаты перестанвоки
     * @param board шахматаня доска
     * @return если все прошло ок
     */
    public boolean replaceFigure(Move move, Board board) {
        board.addFigure(board.getFigure(move.getColFrom(), move.getRowFrom()), move.getColTo(), move.getRowTo());
        board.addFigure(null, move.getColFrom(), move.getRowFrom());
        return true;
    }

    /**
     * Печатае кто ходит
     */
    public void printWhoMove() {
        System.out.printf("\n Ход %s\n", (colorPlayer == Color.White) ? "белых" : "черных");
    }

    /**
     * Проверяет команду
     *
     * @param com   команда
     * @param board шахматная доска
     * @return
     */
    public boolean checkCommand(String com, Board board) {
        if (com.equals("exit")) {
            return false;
        }

        if (com.equals("surrender")) {
            surrenderPlayer();
            return false;
        }

        if (com.equals("help")) {
            helper();
            return false;
        }
        if (com.equals("draw")) {
            proposalDraws();
            return false;
        }

        if (com.charAt(0) == 'a' && com.charAt(1) == ' ') {
            canAttackFigures(com, board, false);
            return false;
        }

        if (com.charAt(0) == 'v' && com.charAt(1) == ' ') {
            threatenFigures(com, board, false);
            return false;
        }

        Move move = new Move(com);

        if (board.getFigure(move.getColFrom(), move.getRowFrom()) == null) {
            System.out.println("Начальная клетка не содержит фигуры");
            return false;
        }
        //Проверка цвета игрока
        if (board.getFigure(move.getColFrom(), move.getRowFrom()).getColor() != colorPlayer) {
            System.out.println("Сейчас дожен ходить " + colorPlayer);
            return false;
        }

        if (board.getFigure(move.getColTo(), move.getRowTo()) != null) {
            if (board.getFigure(move.getColFrom(), move.getRowFrom()).getColor() == board.getFigure(move.getColTo(), move.getRowTo()).getColor()) {
                System.out.println("Одинаковый цвет у фигур");
                return false;
            }
        }

        if (!board.getFigure(move.getColFrom(), move.getRowFrom()).checkMove(move, board, true)) {
            System.out.println("Неправильный ход фигурой");
            return false;
        }

        if (getColorPlayerVictory() != null) return false;
        return true;
    }

    /**
     * Проверяет кто победил
     */
    public void checkVictory() {
        if (getColorPlayerVictory() == null || getColorPlayerVictory() == ColorVictory.Draw) {
            System.out.println("Ничья");
        } else if (getColorPlayerVictory() == ColorVictory.Black) {
            System.out.println("Победил Черный");
        } else {
            System.out.println("Победил Белый");
        }
    }

    /**
     * Метод для сдачи игры
     */
    public void surrenderPlayer() {
        if (getColorPlayer() == Color.Black) {
            colorPlayerVictory = ColorVictory.White;
        } else {
            colorPlayerVictory = ColorVictory.Black;
        }


    }

    /**
     * Метод для просмотра на кого может атаковать фигура
     *
     * @param commmand
     * @param board
     * @param show
     */
    private void canAttackFigures(String commmand, Board board, boolean show) {

        Move move = new Move();
        int col = move.changeLtrToInt(commmand.charAt(2));
        int row = move.changeLtrToInt(commmand.charAt(3));
        System.out.println("Данная фигура с координатами " + commmand + " угрожает: ");
        List<Figure> listFiguresCanAttack = board.getFigure(col, row).canAttack(board, show);
        if (listFiguresCanAttack.size() != 0) {
            Iterator<Figure> iterator = listFiguresCanAttack.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } else if (listFiguresCanAttack.size() == 0) {
            System.out.println("Таких фигур нет");
        }

    }

    /**
     * Метод для простра фигур котоыре угрожают данной фигуре
     *
     * @param commmand
     * @param board
     * @param show
     */
    private void threatenFigures(String commmand, Board board, boolean show) {
        Move move = new Move();
        int col = move.changeLtrToInt(commmand.charAt(2));
        int row = move.changeLtrToInt(commmand.charAt(3));
        System.out.println("Данной фигуре с координатами " + commmand + " угрожают: ");
        List<Figure> listFiguresAthreaten = board.getFigure(col, row).threatenFigures(board, show);
        if (listFiguresAthreaten.size() != 0) {
            Iterator<Figure> iterator = listFiguresAthreaten.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }
        } else if (listFiguresAthreaten.size() == 0) {
            System.out.println("Таких фигур нет");
        }
    }

    /**
     * Проверяет есть ли король на шахматнйо доске
     *
     * @param board
     */
    public void notKing(Board board) {
        if (board.getKing(colorPlayer) == null) {
            colorPlayerVictory = colorPlayer == Color.White ? ColorVictory.Black : ColorVictory.White;
        }
    }

    /**
     * Метод проверяет угрозу для короля
     *
     * @param board шахматная доска
     * @param show
     */
    public void threatenKing(Board board, boolean show) {
        List<Figure> listThreatenKing = board.getKing(colorPlayer).threatenFigures(board, show);
        if (listThreatenKing.size() != 0) {
            System.out.println("ВАШЕМУ КОРОЛЮ ШАХ");
            for (int i = 0; i < listThreatenKing.size(); i++) {
                System.out.println(listThreatenKing.get(i));
            }
        }
    }

    /**
     * Метод вывод подсказку пользователю
     */
    public void helper() {
        System.out.println("Это помощник");
        System.out.println("Если хотети переместить или напасть, введите строку. Пример :");
        System.out.println("a2 a4");
        System.out.println("Если хотите узнать каким фигурам угрожает конкретная фигура , введите строку. Пример: ");
        System.out.println("a c2");
        System.out.println("Если хотите узнать какие фигуры угрожает конкретной фигуре , введите строку. Пример: ");
        System.out.println("v c2");
        System.out.println("Если хотите сдаться , введите строку. Пример: ");
        System.out.println("surrender");
        System.out.println("Если хотите предложить ничью , введите строку. Пример: ");
        System.out.println("draw");
        System.out.println("Если хотите выйти с программы , введите строку. Пример: ");
        System.out.println("exit");
    }

    /**
     * Метод о соглашении ничьи
     */
    private void proposalDraws() {
        nextColor();
        System.out.println("Соперник предложил ничью, если вы согласны напишите yes");
        printWhoMove();
        if (insertMove().equals("yes")) {
            colorPlayerVictory = ColorVictory.Draw;
        }
    }

}
