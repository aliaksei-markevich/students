package ru.artezio.chess.figures;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализующий фиугру Королева
 */
public class Queen extends Figure {

    /**
     * Конструктор
     *
     * @param color цвет фигуры
     */
    public Queen(Color color) {
        super(color);
        super.figureCost = 10;
    }

    @Override
    public boolean checkMove(Move move, Board board, boolean show) {
        if (!super.checkMove(move, board, show)) {
            return false;
        }
        if (!new Bishop(Color.Black).checkMove(move, board, show) &&
                (!new Rook(Color.Black).checkMove(move, board, show))) {
            return false;
        }
        return true;
    }

    @Override
    public String printFigure() {
        return "Q";
    }

    @Override
    public List<Figure> canAttack(Board board, boolean show) {
        List<Figure> listFiguresCanAttack = new ArrayList<Figure>();
        Bishop bishop = new Bishop(this.getColor());
        bishop.setCol(this.getCol());
        bishop.setRow(this.getRow());
        listFiguresCanAttack.addAll(bishop.canAttack(board, show));
        Rook rook = new Rook(this.getColor());
        rook.setCol(this.getCol());
        rook.setRow(this.getRow());
        rook.canAttack(board, show);
        listFiguresCanAttack.addAll(rook.canAttack(board, show));
        return listFiguresCanAttack;
    }
}
