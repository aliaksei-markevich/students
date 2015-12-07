package ru.artezio.shapes;

/**
 * Класс реализующий Прямоугольник
 */
public class Rectangle2D extends Square2D {

    /**
     * Сторона пярмоугольника
     */
    private double rectangleSideB;

    /**
     * Констурктор прямоугольника
     *
     * @param rectangleSide_A сторона А
     * @param rectangleSide_B сторона B
     * @param center          точка центра фигуры
     */
    public Rectangle2D(double rectangleSide_A, double rectangleSide_B, Point2D center) {
        super(rectangleSide_A, center);
        this.rectangleSideB = rectangleSide_B;
    }

    //геттеры
    protected double getRectangleSide_A() {
        return super.getSquareSide();
    }

    protected double getRectangleSide_B() {
        return rectangleSideB;
    }

    /**
     * Метод вычисления площади
     *
     * @return
     */
    @Override
    public double area() {
        return this.getRectangleSide_A() * this.getRectangleSide_B();
    }

    /**
     * Метод рисования
     */
    @Override
    public void drow() {
        System.out.println("Прямоугольник с центром в " + super.getCenter() + " и сторонами a = "
                + this.getRectangleSide_A() + ", b = " + this.getRectangleSide_B());
    }
}
