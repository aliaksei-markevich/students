package ru.artezio.shapes;

/**
 * Класс точка на плоскости
 */
public class Point2D extends Shape2D {

    /**
     * Координаты
     */
    private double x;

    private double y;

    /**
     * Конструктор
     *
     * @param x координата х
     * @param y кооридната у
     */
    public Point2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Метод вычисляет площадь
     *
     * @return возвращает площадь
     */
    @Override
    public double area() {
        return 0;
    }

    /**
     * Метод рисует точку
     */
    @Override
    public void drow() {
        System.out.println("Точка с коориднатами: "+this);
    }

    /**
     * Для удобства отображения переопределяем метод
     *
     * @return строку
     */
    @Override
    public String toString() {
        return ("(" + x + "," + y + ")");
    }

    //гетторы и сетторы
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }
}
