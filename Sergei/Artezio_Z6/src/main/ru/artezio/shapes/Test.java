package ru.artezio.shapes;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Test {

    public static void main(String[] args) {

        List<Shape2D> listShape2D = new ArrayList<Shape2D>();
        listShape2D.add(new Point2D(1, 1));
        listShape2D.add(new Line2D(new Point2D(1, 1), new Point2D(1, 3)));
        listShape2D.add(new Circle2D(new Point2D(1, 1), 2));
        listShape2D.add(new Ellipse2D(new Point2D(1, 1), 2, 4));
        listShape2D.add(new Rectangle2D(2, 4, new Point2D(1, 1)));
        listShape2D.add(new Parallelogram2D(2, 4, new Point2D(1, 1), 40));
        listShape2D.add(new Square2D(4, new Point2D(1, 1)));
        listShape2D.add(new Rhombus2D(2, new Point2D(1, 1), 30, 40));
        listShape2D.add(new Trapeze2D(10, 5, new Point2D(1, 1), 30, 30, 5));
        listShape2D.add(new Triangle2D(new Point2D(1, 1), new Point2D(1, 4), new Point2D(6, 1)));

        List<Point2D> listPoint = new ArrayList<Point2D>();
        listPoint.add(new Point2D(1, 1));
        listPoint.add(new Point2D(1, 4));
        listPoint.add(new Point2D(4, 4));
        listPoint.add(new Point2D(4, 1));
        listShape2D.add(new Polygon2D(listPoint));


        Iterator<Shape2D> iterator = listShape2D.iterator();
        while (iterator.hasNext()) {
            Shape2D shape2d = iterator.next();
            shape2d.drow();
            System.out.println("Площадь = " + shape2d.area());
        }

    }
}
