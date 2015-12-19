package ru.artezio.array;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс реализующий подсчет, заполнение и вывод информации
 */
public class Nomination {

    /**
     * Число судей и спортсменов
     */
    private static final int COUNT_OF_JUDGES = 8;
    private static final int COUNT_OF_SPORTSMAN = 5;

    /**
     * Главная функция
     *
     * @param args
     */
    public static void main(String[] args) {

        List listSportsmans = new ArrayList<Sportsman>();
        fillingList(listSportsmans);
        averageRating(listSportsmans);
        show(listSportsmans);
    }

    /**
     * Метод реализующий заполнение коллекции спортсменами
     *
     * @param list список спортсменов
     */
    private static void fillingList(List list) {

        for (int i = 0; i < COUNT_OF_SPORTSMAN; i++) {
            int[] arrayRating = new int[COUNT_OF_JUDGES];
            for (int j = 0; j < COUNT_OF_JUDGES; j++) {
                arrayRating[j] = (int) (Math.random() * 10) + 1;
            }

            list.add(new Sportsman("name" + i, arrayRating));
        }
    }

    /**
     * Метод реализующий вывод спортстменов
     *
     * @param list список спортсменов
     */
    private static void show(List list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
    }

    /**
     * Метод реализующий подсчет среднего рейтинга
     *
     * @param list список спортсменов
     */
    private static void averageRating(List<Sportsman> list) {
        for (int i = 0; i < list.size(); i++) {
            int[] arrayRating = list.get(i).getArrayRating();
            int max = 0;
            int min = 11;
            int sum = 0;
            double average;
            for (int j = 0; j < COUNT_OF_JUDGES; j++) {
                if (max < arrayRating[j]) {
                    max = arrayRating[j];
                }
                if (min > arrayRating[j]) {
                    min = arrayRating[j];
                }
                sum += arrayRating[j];
            }
            average = (sum - min - max) / (double) (COUNT_OF_JUDGES - 2);
            list.get(i).setAverageRating(average);
        }
    }
}
