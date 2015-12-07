package ru.artezio.shapes;

/**
 * Класс реализующий круг
 */
public class Circle2D extends Ellipse2D {

    /**
     * Конструктор для круга на плоскости
     *
     * @param r радиус круга
     * @param center коориднаты центра круга
     */
    public Circle2D(Point2D center, double r) {
        super(center, r, r);
    }

    /**
     * Метод получения радиуса
     *
     * @return возвращает одну из полусоей (они одинаковы)
     */
    public double getRadius() {
        return super.getHalfAxis_A();
    }


    /**
     * Рисуем круг
     */
    @Override
    public void drow() {
        System.out.println("Круг с центром в " + super.getCenter() + " и радиусом " + this.getRadius());
    }

    /**
     * Вычисляем площадь
     *
     * @return площадь фигуры
     */
    @Override
    public double area() {
        return Math.PI * Math.pow(this.getRadius(), 2);
    }
}
