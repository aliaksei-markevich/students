package ru.artezio.chess.figures;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализует фигуру Король
 */
public class King extends Figure {

    /**
     * Конструктор
     *
     * @param color цвет фигуры
     */
    public King(Color color) {
        super(color);
        super.figureCost = 100;
    }

    @Override
    public boolean checkMove(Move move, Board board, boolean show) {

        if (!super.checkMove(move, board, show)) {
            return false;
        }

        if ((Math.abs(move.getRowFrom() - move.getRowTo()) > 1) || (Math.abs(move.getColFrom() - move.getColTo()) > 1)) {
            if (show) System.out.println("Король так не ходит");
            return false;
        }

        return true;
    }

    @Override
    public String printFigure() {
        return "K";
    }

    @Override
    public List<Figure> canAttack(Board board, boolean show) {
       /*
       1 2 3
       4 K 5
       6 7 8
        */
        List<Figure> listFiguresCanAttack = new ArrayList<Figure>();
        //1
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() - 1, this.getRow() + 1), board, show) &&
                board.getFigure(this.getCol() - 1, this.getRow() + 1) != null &&
                board.getFigure(this.getCol() - 1, this.getRow() + 1).getColor() != this.getColor())
            listFiguresCanAttack.add(board.getFigure(this.getCol() - 1, this.getRow() + 1));
        //2
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol(), this.getRow() + 1), board, show) &&
                board.getFigure(this.getCol(), this.getRow() + 1) != null &&
                board.getFigure(this.getCol(), this.getRow() + 1).getColor() != this.getColor())
            listFiguresCanAttack.add(board.getFigure(this.getCol(), this.getRow() + 1));
        //3
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() + 1, this.getRow() + 1), board, show) &&
                board.getFigure(this.getCol() + 1, this.getRow() + 1) != null &&
                board.getFigure(this.getCol() + 1, this.getRow() + 1).getColor() != this.getColor())
            listFiguresCanAttack.add(board.getFigure(this.getCol() + 1, this.getRow() + 1));
        //4
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() - 1, this.getRow()), board, show) &&
                board.getFigure(this.getCol() - 1, this.getRow()) != null &&
                board.getFigure(this.getCol() - 1, this.getRow()).getColor() != this.getColor())
            listFiguresCanAttack.add(board.getFigure(this.getCol() - 1, this.getRow()));
        //5
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() + 1, this.getRow()), board, show) &&
                board.getFigure(this.getCol() + 1, this.getRow()) != null &&
                board.getFigure(this.getCol() + 1, this.getRow()).getColor() != this.getColor())
            listFiguresCanAttack.add(board.getFigure(this.getCol() + 1, this.getRow()));
        //6
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() - 1, this.getRow() - 1), board, show) &&
                board.getFigure(this.getCol() - 1, this.getRow() - 1) != null &&
                board.getFigure(this.getCol() - 1, this.getRow() - 1).getColor() != this.getColor())
            listFiguresCanAttack.add(board.getFigure(this.getCol() - 1, this.getRow() - 1));
        //7
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol(), this.getRow() - 1), board, show) &&
                board.getFigure(this.getCol(), this.getRow() - 1) != null &&
                board.getFigure(this.getCol(), this.getRow() - 1).getColor() != this.getColor())
            listFiguresCanAttack.add(board.getFigure(this.getCol(), this.getRow() - 1));
        //8
        if (this.checkMove(new Move(this.getCol(), this.getRow(), this.getCol() + 1, this.getRow() - 1), board, show) &&
                board.getFigure(this.getCol() + 1, this.getRow() - 1) != null &&
                board.getFigure(this.getCol() + 1, this.getRow() - 1).getColor() != this.getColor())
            listFiguresCanAttack.add(board.getFigure(this.getCol() + 1, this.getRow() - 1));
        return listFiguresCanAttack;
    }
}
