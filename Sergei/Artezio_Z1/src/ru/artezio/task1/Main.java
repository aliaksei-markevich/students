package ru.artezio.task1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int firstNumber;
        int secondNumber;
        int sum;
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите первое число");
        firstNumber = sc.nextInt();
        System.out.println("Введите второе число");
        secondNumber = sc.nextInt();
        sc.close();
        sum = firstNumber + secondNumber;
        System.out.println("Сумма чисел = " + sum);
    }
}
