package ru.artezio.shapes;

/**
 * Класс который реализует ромб
 */
public class Rhombus2D extends Parallelogram2D {

    /**
     * Наклон
     */
    private double incline;

    /**
     * Конструктор ромба
     *
     * @param rhombusSide сторона ромба
     * @param center      координаты ромба
     * @param angleAlpha  угол альфа
     * @param incline     наклон самой фигуры
     */
    public Rhombus2D(double rhombusSide, Point2D center, double angleAlpha, double incline) {
        super(rhombusSide, rhombusSide, center, angleAlpha);
        this.incline = incline;
    }

    //геттеры и сетторы
    protected double getRhombusSide() {
        return super.getSquareSide();
    }

    protected double getIncline() {
        return incline;
    }

    public void setIncline(double incline) {
        this.incline = incline;
    }

    /**
     * Рисуем фигуру
     */
    @Override
    public void drow() {
        System.out.println("Ромб с центром в " + super.getCenter() + ", c стороной a = " + this.getRhombusSide() +
                " и углом α = " + this.getAngleAlpha() + " и наклоном " + this.getIncline());
    }
}
