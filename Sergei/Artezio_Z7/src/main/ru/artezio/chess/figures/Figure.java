package ru.artezio.chess.figures;


import java.util.ArrayList;
import java.util.List;

/**
 * Асбтрактный класс определяющий фигуры
 */
public abstract class Figure {

    /**
     * Поля фигуры тзначение столбца,строки,цвет и стоимость
     */
    private int col;
    private int row;
    private Color color;
    protected int figureCost;

    /**
     * Проверка хода
     *
     * @param move  сам ход(перемещение фигуры)
     * @param board шахматная доска на которой происходит игра
     * @param show  оперделяет показывать ли сообщения об ошибках(используется при прооверке
     *              на угрожают ли кто фигуре и кому фигура угрожает методы canAttack и threatenFigures)
     * @return возвращает истину если, ход соттветствует фигуре
     */
    public boolean checkMove(Move move, Board board, boolean show) {
        if ((move.getColFrom()) < 0 || (move.getColFrom() > 7)
                || (move.getColTo() < 0 || (move.getColTo() > 7)
                || (move.getRowTo() < 0 || (move.getRowTo() > 7))
                || (move.getRowFrom() < 0 || (move.getRowFrom() > 7)))) {
            if (show) System.out.println("Кооридинаты вышли за границу шахматной доски");
            return false;
        }
        return true;
    }

    /**
     * Метод определяет на какие фигуры можно напасть
     *
     * @param board шахматная доска
     * @param show  оперделяет показывать ли сообщения об ошибках
     * @return коллецию фигур на которые может напасть данная фигура
     */
    public abstract List<Figure> canAttack(Board board, boolean show);

    /**
     * Метод определяет какие фигуры угрожают данной фигуре
     *
     * @param board шахматная доска
     * @param show  оперделяет показывать ли сообщения об ошибках
     * @return коллекцию фигур которые угрожают данной фигуре
     */
    public List<Figure> threatenFigures(Board board, boolean show) {
        List<Figure> listEnemyFigures = new ArrayList<Figure>();
        List<Figure> listThreatenFigure = new ArrayList<Figure>();
        //Собираем все живые фигуры противника
        for (int i = 0; i <= 7; i++) {
            for (int j = 0; j <= 7; j++) {
                if (board.getFigure(i, j) != null && board.getFigure(i, j).getColor() != this.getColor()) {
                    listEnemyFigures.add(board.getFigure(i, j));
                }
            }
        }
        for (int i = 0; i < listEnemyFigures.size(); i++) {
            List<Figure> canAttackFigure = listEnemyFigures.get(i).canAttack(board, show);
            for (int j = 0; j < canAttackFigure.size(); j++) {
                if ((canAttackFigure.get(j).getCol() == this.getCol()) && (canAttackFigure.get(j).getRow() == this.getRow())) {
                    listThreatenFigure.add(listEnemyFigures.get(i));
                }

            }
        }
        return listThreatenFigure;
    }

    /**
     * Метод переводит с int в char для удобочитаемости
     *
     * @param position позиция
     * @return буквы на шахматной доске, которая соответсвует фигуре
     */
    protected char intToChar(int position) {
        switch (position) {
            case 0:
                return 'a';
            case 1:
                return 'b';
            case 2:
                return 'c';
            case 3:
                return 'd';
            case 4:
                return 'e';
            case 5:
                return 'f';
            case 6:
                return 'g';
            case 7:
                return 'h';
            default:
                return ' ';
        }
    }

    /**
     * Рисует фигуру
     *
     * @return возвращает букву фигуры
     */
    public abstract String printFigure();

    /**
     * Конструктор
     *
     * @param color цвет фигуры
     */
    public Figure(Color color) {
        this.color = color;
    }

    //геттеры и сетторы
    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public Color getColor() {
        return color;
    }

    public int getFigureCost() {
        return figureCost;
    }

    /**
     * Переопределяем метод для удобочитемости
     *
     * @return строку
     */
    @Override
    public String toString() {
        return "" + this.intToChar(col) +
                (this.row + 1) + " " + this.getClass().getSimpleName() + " стоимость фигуры : " + this.getFigureCost();
    }
}
