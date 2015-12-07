package ru.artezio.shapes;

import java.security.ProtectionDomain;

/**
 * Класс реализующий квадрат
 */
public class Square2D extends Shape2D {

    /**
     * Сторона квадрата
     */
    private double squareSide;

    /**
     * Координаты центра квадрата
     */
    private Point2D center;

    /**
     * Конструктор квадрата
     *
     * @param squareSide сторона
     * @param center     коориднаты центра
     */
    public Square2D(double squareSide, Point2D center) {
        this.squareSide = squareSide;
        this.center = center;
    }

    //геттеры
    protected double getSquareSide() {
        return squareSide;
    }

    protected Point2D getCenter() {
        return center;
    }

    /**
     * Метод вычисляет площадь
     *
     * @return площадь фигуры
     */
    @Override
    public double area() {
        return this.getSquareSide() * this.getSquareSide();
    }

    /**
     * Метод рисует площадь
     */
    @Override
    public void drow() {
        System.out.println("Квадрат с центром в " + this.getCenter() + " и стороной " + this.getSquareSide());
    }
}
