package ru.artezio.shapes;

/**
 * Класс реализующий трапецию
 */
public class Trapeze2D extends Parallelogram2D {

    /**
     * Поля для хранения угла бета и выоты трапеции
     */
    private double angleBeta;
    private double height;

    /**
     * Конструктор тарпеции
     *
     * @param trapezeSide_A сторона А
     * @param trapezeSide_B сторона В
     * @param center        коориднаты центра фигуры
     * @param angleAlpha    угол альфа
     * @param angleBeta     угол бета
     * @param height        высота трапеции
     */
    public Trapeze2D(double trapezeSide_A, double trapezeSide_B, Point2D center, double angleAlpha, double angleBeta, double height) {
        super(trapezeSide_A, trapezeSide_B, center, angleAlpha);
        this.angleBeta = angleBeta;
        this.height = height;
    }

    //геттеры и сетторы
    public double getAngleBeta() {
        return angleBeta;
    }

    public void setAngleBeta(double angleBeta) {
        this.angleBeta = angleBeta;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    /**
     * Метод вычисляет площадь
     *
     * @return площадь фигуры
     */
    @Override
    public double area() {
        return this.height * (super.getRectangleSide_A() + super.getRectangleSide_B()) / 2;
    }

    /**
     * Метод рисует фигуру
     */
    @Override
    public void drow() {
        System.out.println("Трапеция с центром в " + super.getCenter() + ", c сторонами a = " + super.getRectangleSide_A() +
                ", b = " + super.getRectangleSide_B() + " , угломи α = " + getAngleAlpha() + ", β = " + getAngleBeta() +
                " и высотой h = " + this.getHeight());
    }
}
