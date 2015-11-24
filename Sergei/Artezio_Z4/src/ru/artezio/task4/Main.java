package ru.artezio.task4;

import java.util.Scanner;

public class Main {

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

    private static int randomNumber(int a, int b) {
        int randNum;
        randNum = (int) (Math.random() * (b - a + 1)) + a;
        return randNum;
    }
}
