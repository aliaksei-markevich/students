package ru.artezio.task2;

import java.util.Scanner;

/**
 * Класс реализующий приветствие пользователя
 */
public class Task2 {

    /**
     * Главный метод
     *
     * @param args
     */
    public static void main(String[] args) {
        String nameUser;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите Ваше имя");
        nameUser = sc.nextLine();
        sc.close();
        System.out.println("Привет, " + nameUser + "!");
    }
}
