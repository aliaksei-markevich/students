package ru.artezio.shapes;

/**
 * Класс реализующий эллипс
 */
public class Ellipse2D extends Shape2D {

    /**
     * Коориданата центра
     */
    private Point2D center;

    /**
     * Знаечние полуосей эллипса
     */
    private double halfAxis_A;
    private double halfAxis_B;

    /**
     * Конструктор эиллпса
     *
     * @param center     центр эллипса
     * @param halfAxis_A полуось a
     * @param halfAxis_B полуось b
     */
    public Ellipse2D(Point2D center, double halfAxis_A, double halfAxis_B) {
        this.center = center;
        this.halfAxis_A = halfAxis_A;
        this.halfAxis_B = halfAxis_B;
    }

    @Override
    public double area() {
        return this.halfAxis_A * this.halfAxis_B * Math.PI;
    }

    @Override
    public void drow() {
        System.out.println("Эллипс с центром в " + this.getCenter() + " и полуосями a = " +
                this.halfAxis_A + ", b = " + this.halfAxis_B);
    }

    //Геттеры и сеторы
    protected void setHalfAxis_A(double halfAxis_A) {
        this.halfAxis_A = halfAxis_A;
    }

    public Point2D getCenter() {
        return center;
    }

    public void setCenter(Point2D center) {
        this.center = center;
    }

    protected double getHalfAxis_A() {
        return halfAxis_A;
    }
}
