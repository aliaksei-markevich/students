package ru.artezio.shapes;

import java.util.Iterator;
import java.util.List;

/**
 * класс реализующий многоугольник
 */
public class Polygon2D extends Shape2D {

    /**
     * Список вершин многоугольника
     */
    private List<Point2D> listPoints;

    /**
     * Конструктор
     *
     * @param listPoints список вершин
     */
    public Polygon2D(List<Point2D> listPoints) {
        this.listPoints = listPoints;
    }

    //геттеры и сетторы
    public List<Point2D> getListPoints() {
        return listPoints;
    }

    public void setListPoints(List<Point2D> listPoints) {
        this.listPoints = listPoints;
    }

    /**
     * Метод вычисления площади
     *
     * @return
     */
    @Override
    public double area() {
        double polygonArea = 0;
        for (int i = 0; i < listPoints.size(); i++) {
            if (i == listPoints.size() - 1) {
                polygonArea += ((listPoints.get(i).getX() + listPoints.get(0).getX()) *
                        ((listPoints.get(i).getY() - listPoints.get(0).getY()))) / 2;
            } else {
                polygonArea += ((listPoints.get(i).getX() + listPoints.get(i + 1).getX()) *
                        ((listPoints.get(i).getY() - listPoints.get(i + 1).getY()))) / 2;
            }
        }
        return polygonArea;
    }

    /**
     * Рисуем фигуру
     */
    @Override
    public void drow() {
        Iterator<Point2D> iterator = listPoints.iterator();
        System.out.println("Многоугольник с вершинами :");
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
