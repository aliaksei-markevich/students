package ru.artezio.chess.figures;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует фигуру Конь
 */
public class Knight extends Figure {

    /**
     * Конструктор
     *
     * @param color цвет фигуры
     */
    public Knight(Color color) {
        super(color);
        super.figureCost = 3;
    }

    @Override
    public boolean checkMove(Move move, Board board, boolean show) {
        if (!super.checkMove(move, board, show)) {
            return false;
        }

        if (((Math.abs(move.getColFrom() - move.getColTo()) == 1) &&
                (Math.abs(move.getRowFrom() - move.getRowTo()) == 2)) || ((Math.abs(move.getColFrom() - move.getColTo()) == 2) &&
                (Math.abs(move.getRowFrom() - move.getRowTo()) == 1))) {
            return true;
        }
        if (show) System.out.println("Плохой ход конем");
        return false;
    }

    @Override
    public String printFigure() {
        return "k";
    }

    @Override
    public List<Figure> canAttack(Board board, boolean show) {
        List<Figure> listFiguresCanAttack = new ArrayList<Figure>();
        //Верхнее-левое
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() - 1, this.getRow() + 2), board, show) &&
                board.getFigure(this.getCol() - 1, this.getRow() + 2) != null &&
                board.getFigure(this.getCol() - 1, this.getRow() + 2).getColor() != this.getColor()) {
            listFiguresCanAttack.add(board.getFigure(this.getCol() - 1, this.getRow() + 2));
        }
        //Верхнее-правое
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() + 1, this.getRow() + 2), board, show) &&
                board.getFigure(this.getCol() + 1, this.getRow() + 2) != null &&
                board.getFigure(this.getCol() + 1, this.getRow() + 2).getColor() != this.getColor()) {
            listFiguresCanAttack.add(board.getFigure(this.getCol() + 1, this.getRow() + 2));
        }
        //Правое-верхнее
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() + 2, this.getRow() + 1), board, show) &&
                board.getFigure(this.getCol() + 2, this.getRow() + 1) != null &&
                board.getFigure(this.getCol() + 2, this.getRow() + 1).getColor() != this.getColor()) {
            listFiguresCanAttack.add(board.getFigure(this.getCol() + 2, this.getRow() + 1));
        }
        //Правое-нижнее
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() + 2, this.getRow() - 1), board, show) &&
                board.getFigure(this.getCol() + 2, this.getRow() - 1) != null &&
                board.getFigure(this.getCol() + 2, this.getRow() - 1).getColor() != this.getColor()) {
            listFiguresCanAttack.add(board.getFigure(this.getCol() + 2, this.getRow() - 1));
        }
        //Нижнее-правое
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() + 1, this.getRow() - 2), board, show) &&
                board.getFigure(this.getCol() + 1, this.getRow() - 2) != null &&
                board.getFigure(this.getCol() + 1, this.getRow() - 2).getColor() != this.getColor()) {
            listFiguresCanAttack.add(board.getFigure(this.getCol() + 1, this.getRow() - 2));
        }
        //Нижнее-левое
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() - 1, this.getRow() - 2), board, show) &&
                board.getFigure(this.getCol() - 1, this.getRow() - 2) != null &&
                board.getFigure(this.getCol() - 1, this.getRow() - 2).getColor() != this.getColor()) {
            listFiguresCanAttack.add(board.getFigure(this.getCol() - 1, this.getRow() - 2));
        }
        //Левое-нижнее
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() - 2, this.getRow() - 1), board, show) &&
                board.getFigure(this.getCol() - 2, this.getRow() - 1) != null &&
                board.getFigure(this.getCol() - 2, this.getRow() - 1).getColor() != this.getColor()) {
            listFiguresCanAttack.add(board.getFigure(this.getCol() - 2, this.getRow() - 1));
        }
        //Левое-верхнее
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() - 2, this.getRow() + 1), board, show) &&
                board.getFigure(this.getCol() - 2, this.getRow() + 1) != null &&
                board.getFigure(this.getCol() - 2, this.getRow() + 1).getColor() != this.getColor()) {
            listFiguresCanAttack.add(board.getFigure(this.getCol() - 2, this.getRow() + 1));
        }
        return listFiguresCanAttack;
    }
}
