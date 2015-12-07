package ru.artezio.chess.figures;

/**
 * Класс реализующий шахматную доску
 */
public class Board {

    public static final int SIZE_COLS=8;
    public static final int SIZE_ROWS=8;

    /**
     * используется для хранения фигур на доске
     */
    private Figure[][] board = new Figure[SIZE_COLS][SIZE_ROWS];

    /**
     * Конструктор
     */
    public Board() {
        super();
    }

    /**
     * Добавление фигуру на доску
     *
     * @param figure фигура
     * @param col    колонка
     * @param row    строчка
     */
    public void addFigure(Figure figure, int col, int row) {
        this.board[col][row] = figure;
        if (figure != null) {
            figure.setCol(col);
            figure.setRow(row);
        }
    }

    /**
     * Рисует шахматную доску
     */
    public void PrintBoard() {
        for (int j = board.length - 1; j >= 0; j--) {
            for (int i = 0; i < board.length; i++) {

                String sym = "";
                if (i == 0) {
                    sym += (j + 1) + " ";
                }

                Figure figure = board[i][j];

                if (figure == null) {
                    sym += "__";
                } else {
                    sym += figure.printFigure();
                    if (figure.getColor() == Color.Black)
                        sym = sym + "b";
                    else
                        sym = sym + "w";

                }

                System.out.print(sym + " ");
            }
            System.out.println();
        }
        System.out.println("  A  B  C  D  E  F  G  H");
    }

    /**
     * Мето позволяте доступ к фигуре на шахматной доске
     *
     * @param col колонка
     * @param row строчка
     * @return
     */
    public Figure getFigure(int col, int row) {
        return board[col][row];
    }

    /**
     * Проверяет есть ли король на шахматной доске
     *
     * @param color цвет короля
     * @return короля заданного цвета или Null если его нет
     */
    public Figure getKing(Color color) {
        for (Figure[] rows : board) {
            for (Figure figure : rows) {
                if (figure != null && figure.getClass().getSimpleName().equals("King") && figure.getColor() == color)
                    return figure;
            }
        }
        return null;
    }
}
