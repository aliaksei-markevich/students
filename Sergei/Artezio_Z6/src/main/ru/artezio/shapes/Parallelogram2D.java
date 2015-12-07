package ru.artezio.shapes;

/**
 * Класс реализующий параллелограмм
 */
public class Parallelogram2D extends Rectangle2D {

    /**
     * Угол альфа
     */
    private double angleAlpha;

    /**
     * Конструктор параллелограма
     *
     * @param parallelogramSide_A сторона А
     * @param parallelogramSide_B сторона B
     * @param center              точка центра
     * @param angleAlpha          угол альфа в параллелограмме
     */
    public Parallelogram2D(double parallelogramSide_A, double parallelogramSide_B,
                           Point2D center, double angleAlpha) {
        super(parallelogramSide_A, parallelogramSide_B, center);
        this.angleAlpha = angleAlpha;
    }

    //геттеры
    public double getAngleAlpha() {
        return angleAlpha;
    }

    public void setAngleAlpha(double angleAlpha) {
        this.angleAlpha = angleAlpha;
    }

    /**
     * Вычисляем площадь
     *
     * @return площадь фигуры
     */
    @Override
    public double area() {
        return super.getRectangleSide_A() * super.getRectangleSide_A() * Math.sin(Math.toRadians(angleAlpha));
    }

    /**
     * Рисуем фигуру
     */
    @Override
    public void drow() {
        System.out.println("Параллелограмм с центром в " + super.getCenter() + ", c сторонами a = " +
                super.getRectangleSide_A() + ", b = " + super.getRectangleSide_B() + " и углом α = " +
                this.getAngleAlpha());
    }
}
