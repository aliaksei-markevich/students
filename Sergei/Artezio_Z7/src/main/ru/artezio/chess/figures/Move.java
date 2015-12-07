package ru.artezio.chess.figures;

public class Move {

    private int colFrom;
    private int rowFrom;
    private int colTo;
    private int rowTo;

    public Move(int colFrom, int rowFrom, int colTo, int rowTo) {
        this.colFrom = colFrom;
        this.rowFrom = rowFrom;
        this.colTo = colTo;
        this.rowTo = rowTo;
    }

    public Move(String move) {
        String[] arrMove = move.split(" ");
        String From = arrMove[0];
        String To = arrMove[1];
        this.colFrom = changeLtrToInt(From.charAt(0));
        this.rowFrom = changeLtrToInt(From.charAt(1));
        this.colTo = changeLtrToInt(To.charAt(0));
        this.rowTo = changeLtrToInt(To.charAt(1));
    }

    public Move() {
    }

    public int changeLtrToInt(char ltr) {
        switch (ltr) {
            case '1':
            case 'a':
                return 0;
            case '2':
            case 'b':
                return 1;
            case '3':
            case 'c':
                return 2;
            case '4':
            case 'd':
                return 3;
            case '5':
            case 'e':
                return 4;
            case '6':
            case 'f':
                return 5;
            case '7':
            case 'g':
                return 6;
            case '8':
            case 'h':
                return 7;
            default:
                return -1;
        }
    }


    public int getColFrom() {
        return colFrom;
    }

    public void setColFrom(int colFrom) {
        this.colFrom = colFrom;
    }

    public int getRowFrom() {
        return rowFrom;
    }

    public void setRowFrom(int rowFrom) {
        this.rowFrom = rowFrom;
    }

    public int getColTo() {
        return colTo;
    }

    public void setColTo(int colTo) {
        this.colTo = colTo;
    }

    public int getRowTo() {
        return rowTo;
    }

    public void setRowTo(int rowTo) {
        this.rowTo = rowTo;
    }
}
