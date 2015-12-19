package ru.artezio.array;

/**
 * Класс реализующий хранине данных спортсмена
 */
public class Sportsman {

    /**
     * Переменные позволяющие описать спортсмена
     */
    private String name;
    private int[] arrayRating;
    private double averageRating;

    /**
     * Конструктор
     * @param name имя
     * @param arrayRating список оценок
     */
    public Sportsman(String name, int[] arrayRating) {
        this.name = name;
        this.arrayRating = arrayRating;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.arrayRating.length; i++) {
            str.append(Integer.toString(this.arrayRating[i]) + " ");
        }
        return "Имя:  " + this.name + " Оценки: " + str + " Средняя оценка: " + this.averageRating;
    }

    public String getName() {
        return name;
    }

    public int[] getArrayRating() {
        return arrayRating;
    }

    public double getAverageRating() {
        return averageRating;
    }

    public void setAverageRating(double averageRating) {
        this.averageRating = averageRating;
    }
}
