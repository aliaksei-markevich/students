package ru.artezio.chess.figures;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует класс Слон
 */
public class Bishop extends Figure {

    /**
     * Конструктор
     *
     * @param color цвет фигуры
     */
    public Bishop(Color color) {
        super(color);
        super.figureCost = 3;
    }


    @Override
    public boolean checkMove(Move move, Board board, boolean show) {
        if (!super.checkMove(move, board, show)) {
            return false;
        }

        if (Math.abs(move.getColFrom() - move.getColTo()) != Math.abs(move.getRowFrom() - move.getRowTo())) {
            if (show) System.out.println("Слон так не ходит");
            return false;
        }

        int rowStart, rowEnd, colStart, colEnd, change;
        rowStart = Math.min(move.getRowFrom(), move.getRowTo());
        rowEnd = Math.max(move.getRowFrom(), move.getRowTo());
        colStart = (move.getColFrom() < move.getColTo()) ? move.getColFrom() : move.getColTo();
        colEnd = (move.getColFrom() < move.getColTo()) ? move.getColTo() : move.getColFrom();
        for (int i = 1; i < rowEnd - rowStart; i++) {
            if (move.getColFrom() < move.getColTo() && (move.getRowFrom() > move.getRowTo())) {
                colStart = move.getColTo();
                change = colStart - i;
            } else if (move.getColFrom() > move.getColTo() && move.getRowFrom() < move.getRowTo()) {
                change = colEnd - i;
            } else {
                change = colStart + i;
            }
            if (board.getFigure(change, rowStart + i) != null) {
                if (show)
                    System.out.println(intToChar(move.getColFrom()) + "" + (move.getRowFrom() + 1) + " и окончанием хода "
                            + intToChar(move.getColTo()) + (move.getRowTo() + 1) + " содержится фигуры! " +
                            intToChar(change) + (rowStart + i + 1));
                return false;
            }
        }

        return true;
    }

    @Override
    public String printFigure() {
        return "B";
    }

    @Override
    public List<Figure> canAttack(Board board, boolean show) {
        List<Figure> listFiguresCanAttack = new ArrayList<Figure>();
        //проверяем верх-лево
        for (int i = this.getRow() + 1, j = this.getCol() - 1;
             this.checkMove(new Move(this.getCol(), this.getRow(), j, i), board, show); i++, j--)
            if ((board.getFigure(j, i) != null) && (board.getFigure(j, i).getColor() != this.getColor())) {
                listFiguresCanAttack.add(board.getFigure(j, i));

            }
        //проверяем верх-парво
        for (int i = this.getRow() + 1, j = this.getCol() + 1;
             this.checkMove(new Move(this.getCol(), this.getRow(), j, i), board, show); i++, j++)
            if ((board.getFigure(j, i) != null) && (board.getFigure(j, i).getColor() != this.getColor())) {
                listFiguresCanAttack.add(board.getFigure(j, i));

            }
        //проверяем низ-парво
        for (int i = this.getRow() - 1, j = this.getCol() + 1;
             this.checkMove(new Move(this.getCol(), this.getRow(), j, i), board, show); i--, j++)
            if ((board.getFigure(j, i) != null) && (board.getFigure(j, i).getColor() != this.getColor())) {
                listFiguresCanAttack.add(board.getFigure(j, i));

            }
        //проверяем низ-лево
        for (int i = this.getRow() - 1, j = this.getCol() - 1;
             this.checkMove(new Move(this.getCol(), this.getRow(), j, i), board, show); i--, j--)
            if ((board.getFigure(j, i) != null) && (board.getFigure(j, i).getColor() != this.getColor())) {
                listFiguresCanAttack.add(board.getFigure(j, i));

            }
        return listFiguresCanAttack;
    }
}
