package ru.artezio.task3;

import java.util.Scanner;

/**
 * Класс реализующий сортировку
 */
public class Task3 {

    /**
     * Главный метод
     *
     * @param args
     */
    public static void main(String[] args) {
        int size;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите количество чисел в массиве");
        size = sc.nextInt();
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = sc.nextInt();
        }
        sc.close();
        show(array);
        sort(array);
        show(array);
    }

    /**
     * Вывод массива
     *
     * @param array входящий массив
     */
    private static void show(int[] array) {
        System.out.println("Массив: ");
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    /**
     * Сортировка массива
     *
     * @param array входящий массив
     */
    private static void sort(int[] array) {
        for (int i = 0; i < array.length; i++) {
            int min = array[i];
            int imin = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < min) {
                    min = array[j];
                    imin = j;
                }
            }
            if (i != imin) {
                int temp = array[i];
                array[i] = array[imin];
                array[imin] = temp;
            }
        }
    }
}
