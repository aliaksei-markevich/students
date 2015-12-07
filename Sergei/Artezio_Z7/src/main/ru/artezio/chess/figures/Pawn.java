package ru.artezio.chess.figures;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует фигуру Пешка
 */
public class Pawn extends Figure {

    /**
     * Конструктор
     *
     * @param color цвет фиугры
     */
    public Pawn(Color color) {
        super(color);
        super.figureCost = 1;
    }

    @Override
    public boolean checkMove(Move move, Board board, boolean show) {

        if (!super.checkMove(move, board, show)) {
            return false;
        }
        //не может ходить на 2 клетки
        if (Math.abs(move.getColFrom() - move.getColTo()) > 1) {
            if (show) System.out.println("Пешка не может ходить больше чем через 2 столбца");
            return false;
        }

        if ((move.getColFrom() == move.getColTo()) && (board.getFigure(move.getColTo(), move.getRowTo()) != null)) {
            if (show) System.out.println("Позиция занета другой фигурой");
            return false;
        }

        if ((move.getColFrom() != move.getColTo()) &&
                (board.getFigure(move.getColTo(), move.getRowTo()) == null)) {
            if (show) System.out.println("Неверный ход");
            return false;
        }

        if ((move.getColTo() == move.getColFrom()) &&
                (
                        ((super.getColor() == Color.White) && ((move.getRowTo() - move.getRowFrom()) > 1) && move.getRowFrom() != 1)
                                ||
                                ((Color.Black == super.getColor()) && ((move.getRowFrom() - move.getRowTo()) > 1) && move.getRowFrom() != 6)
                                ||
                                ((Color.White == super.getColor()) && ((move.getRowTo() - move.getRowFrom()) > 2) && move.getRowFrom() == 1)
                                ||
                                ((Color.Black == super.getColor()) && ((move.getRowFrom() - move.getRowTo()) > 2) && move.getRowFrom() == 6)
                ))
            return false;

        if ((move.getRowTo() < move.getRowFrom()) &&
                (board.getFigure(move.getColFrom(), move.getRowFrom()).getColor() == Color.White)) {
            if (show) System.out.println("Назад пешкой ходить нельзя");
            return false;
        }

        if ((move.getRowTo() > move.getRowFrom()) &&
                (board.getFigure(move.getColFrom(), move.getRowFrom()).getColor() == Color.Black)) {
            if (show) System.out.println("Назад пешкой ходить нельзя");
            return false;
        }

        return true;
    }

    @Override
    public String printFigure() {
        return "P";
    }

    @Override
    public List<Figure> canAttack(Board board, boolean show) {

        List<Figure> listFiguresCanAttack = new ArrayList<Figure>();
        //для белых
        if (this.getColor() == Color.White) {
            if ((this.getCol() - 1 >= 0) && (board.getFigure(this.getCol() - 1, this.getRow() + 1) != null)
                    && (board.getFigure(this.getCol() - 1, this.getRow() + 1).getColor() != this.getColor())
                    && (this.getRow() + 1 <= 7)) {
                listFiguresCanAttack.add(board.getFigure(this.getCol() - 1, this.getRow() + 1));
            }
            if ((this.getCol() + 1 <= 7) && (board.getFigure(this.getCol() + 1, this.getRow() + 1) != null) &&
                    (board.getFigure(this.getCol() + 1, this.getRow() + 1).getColor() != this.getColor())
                    && (this.getRow() + 1 <= 7))
                listFiguresCanAttack.add(board.getFigure(this.getCol() + 1, this.getRow() + 1));
        }
        //для черных
        if (this.getColor() == Color.Black) {
            if ((this.getCol() - 1 >= 0) && (board.getFigure(this.getCol() - 1, this.getRow() - 1) != null)
                    && (board.getFigure(this.getCol() - 1, this.getRow() - 1).getColor() != this.getColor())
                    && (this.getRow() - 1 >= 0)) {
                listFiguresCanAttack.add(board.getFigure(this.getCol() - 1, this.getRow() - 1));
            }
            if ((this.getCol() + 1 <= 7) && (board.getFigure(this.getCol() + 1, this.getRow() - 1) != null) &&
                    (board.getFigure(this.getCol() + 1, this.getRow() - 1).getColor() != this.getColor())
                    && (this.getRow() - 1 >= 0))
                listFiguresCanAttack.add(board.getFigure(this.getCol() + 1, this.getRow() - 1));
        }
        return listFiguresCanAttack;
    }

}
