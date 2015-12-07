package ru.artezio.shapes;

/**
 * Класс реализующий линию
 */
public class Line2D extends Shape2D {

    /**
     * Координаты точек
     */
    private Point2D endPoint;
    private Point2D startPoint;

    /**
     * Констурктор точки
     *
     * @param startPoint начальная кооридната
     * @param endPoint   конечная кооридната
     */
    public Line2D(Point2D startPoint, Point2D endPoint) {
        this.endPoint = endPoint;
        this.startPoint = startPoint;
    }

    //Геттеры и сетторы
    public Point2D getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(Point2D endPoint) {
        this.endPoint = endPoint;
    }

    public Point2D getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(Point2D startPoint) {
        this.startPoint = startPoint;
    }

    /**
     * Рисуем фигуру
     */
    @Override
    public void drow() {
        System.out.println("Линия с  коориднатами начала " + this.getStartPoint() + " и конца " + this.getEndPoint());
    }

    /**
     * Вычисляем площадь
     *
     * @return 0 так как прямая
     */
    @Override
    public double area() {
        return 0;
    }
}
