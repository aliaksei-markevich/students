package ru.artezio.shapes;


/**
 * Класс реализующий треугольник
 */
public class Triangle2D extends Shape2D {

    /**
     * Переменные для хранения точек треугольник
     */
    private Point2D firstPoint;
    private Point2D secondPoint;
    private Point2D thirdPoint;

    /**
     * Конструктор треугольника
     *
     * @param firstPoint  первая вершина
     * @param secondPoint вторая вершина
     * @param thirdPoint  третья вершина
     */
    public Triangle2D(Point2D firstPoint, Point2D secondPoint, Point2D thirdPoint) {
        this.firstPoint = firstPoint;
        this.secondPoint = secondPoint;
        this.thirdPoint = thirdPoint;
    }

    //геттеры и сетторы
    public Point2D getFirstPoint() {
        return firstPoint;
    }

    public void setFirstPoint(Point2D firstPoint) {
        this.firstPoint = firstPoint;
    }

    public Point2D getSecondPoint() {
        return secondPoint;
    }

    public void setSecondPoint(Point2D secondPoint) {
        this.secondPoint = secondPoint;
    }

    public Point2D getThirdPoint() {
        return thirdPoint;
    }

    public void setThirdPoint(Point2D thirdPoint) {
        this.thirdPoint = thirdPoint;
    }

    /**
     * Метод вычисляет площадь
     *
     * @return площадь фигуры
     */
    @Override
    public double area() {
        return Math.abs((this.getFirstPoint().getX() - this.getThirdPoint().getX()) *
                (this.getSecondPoint().getY() - this.getThirdPoint().getY()) -
                (this.getSecondPoint().getX() - this.getThirdPoint().getX()) *
                        (this.getFirstPoint().getY() - this.getThirdPoint().getY())) / 2;
    }

    /**
     * Метод рисует фигуру
     */
    @Override
    public void drow() {
        System.out.println("Треугольник с коориднатами вершин " + this.getFirstPoint() + ", " +
                this.getSecondPoint() + ", " + this.getThirdPoint());
    }
}
