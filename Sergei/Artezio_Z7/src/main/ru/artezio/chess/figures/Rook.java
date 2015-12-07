package ru.artezio.chess.figures;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует фигуру Ладья
 */
public class Rook extends Figure {

    private static final int SIZE_CHESS=8;
    /**
     * Конструктор
     *
     * @param color цвет фигуры
     */
    public Rook(Color color) {
        super(color);
        super.figureCost = 5;
    }

    @Override
    public boolean checkMove(Move move, Board board, boolean show) {

        if (!super.checkMove(move, board, show)) {
            return false;
        }

        if ((move.getRowFrom() != move.getRowTo())
                && (move.getColTo() != move.getColFrom())) {
            if (show) System.out.println("Ладьей так ходить нельзя");
            return false;
        }

        //минимальный и максимальные
        int rowStart, rowEnd, colEnd, colStart;
        rowStart = Math.min(move.getRowFrom(), move.getRowTo());
        rowEnd = Math.max(move.getRowFrom(), move.getRowTo());
        colEnd = Math.max(move.getColFrom(), move.getColTo());
        colStart = Math.min(move.getColFrom(), move.getColTo());

        //горизонталь
        if (move.getRowFrom() == move.getRowTo()) {
            for (int i = 1; i < colEnd - colStart; i++) {
                if ((board.getFigure(colStart + i, rowStart) != null) && (move.getColFrom() != (colStart + i))) {
                    if (show)
                        System.out.println(intToChar(move.getColFrom()) + "" + (move.getRowFrom() + 1) +
                                " и окончанием хода " + intToChar(move.getColTo()) + (move.getRowTo() + 1) +
                                " содержится фигуры! в " + intToChar(colStart + i + 1) + rowStart);
                    return false;
                }
            }
        }

        //вертикаль
        if (move.getColTo() == move.getColFrom()) {
            for (int i = 1; i < rowEnd - rowStart; i++) {
                if (((board.getFigure(colStart, rowStart + i)) != null) && (move.getRowFrom() != (rowStart + i))) {
                    System.out.println(intToChar(move.getColFrom()) + "" + (move.getRowFrom() + 1) +
                            " и окончанием хода " + intToChar(move.getColTo()) +
                            (move.getRowTo() + 1) + " содержится фигуры!" + intToChar(colStart) + (rowStart + i + 1));
                    return false;
                }
            }
        }


        return true;
    }

    @Override
    public String printFigure() {
        return "R";
    }

    @Override
    public List<Figure> canAttack(Board board, boolean show) {
        List<Figure> listFiguresCanAttack = new ArrayList<Figure>();
        //проверяем верхнюю часть
        for (int i = 1; i < SIZE_CHESS - this.getRow(); i++) {
            if (board.getFigure(this.getCol(), this.getRow() + i) != null) {
                if (board.getFigure(this.getCol(), this.getRow() + i).getColor() != this.getColor()) {
                    listFiguresCanAttack.add(board.getFigure(this.getCol(), this.getRow() + i));
                    break;
                }
                if (board.getFigure(this.getCol(), this.getRow() + i).getColor() == this.getColor()) {
                    break;
                }
            }
        }
        //проверяем нижнюю часть
        for (int i = this.getRow() - 1; i >= 0; i--) {
            if (board.getFigure(this.getCol(), i) != null) {
                if (board.getFigure(this.getCol(), i).getColor() != this.getColor()) {
                    listFiguresCanAttack.add(board.getFigure(this.getCol(), i));
                    break;
                }
                if (board.getFigure(this.getCol(), i).getColor() == this.getColor()) {
                    break;
                }
            }
        }
        //проверяем левую часть
        for (int i = this.getCol() - 1; i >= 0; i--) {
            if (board.getFigure(i, this.getRow()) != null) {
                if (board.getFigure(i, this.getRow()).getColor() != this.getColor()) {
                    listFiguresCanAttack.add(board.getFigure(i, this.getRow()));
                    break;
                }
                if (board.getFigure(i, this.getRow()).getColor() == this.getColor()) {
                    break;
                }
            }
        }

        //проверяем правую часть
        for (int i = this.getCol() + 1; i < SIZE_CHESS; i++) {
            if (board.getFigure(i, this.getRow()) != null) {
                if (board.getFigure(i, this.getRow()).getColor() != this.getColor()) {
                    listFiguresCanAttack.add(board.getFigure(i, this.getRow()));
                    break;
                }
                if (board.getFigure(i, this.getRow()).getColor() == this.getColor()) {
                    break;
                }
            }
        }
        return listFiguresCanAttack;
    }
}
