package ru.artezio.task4;

import java.util.Scanner;

/**
 * Класс реализует вывод рандомного числа с отрезка
 */
public class Task4 {

    /**
     * Главный метод
     *
     * @param args
     */
    public static void main(String[] args) {
        int a;
        int b;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите a");
        a = sc.nextInt();
        System.out.println("Введите b");
        b = sc.nextInt();
        sc.close();
        System.out.println(randomNumber(a, b));
    }

    /**
     * Возвращает рандомное число с отрезка
     *
     * @param a первая граница
     * @param b вторая граница
     * @return рандомное число с отрезка
     */
    private static int randomNumber(int a, int b) {
        int randNum;
        randNum = (int) (Math.random() * (b - a + 1)) + a;
        return randNum;
    }
}
