package ru.artezio.task2;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String nameUser;
        Scanner sc=new Scanner(System.in);
        System.out.println("Введите Ваше имя");
        nameUser=sc.nextLine();
        sc.close();
        System.out.println("Привет, "+nameUser+"!");
    }
}
