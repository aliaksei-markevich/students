package ru.artezio.errors;

/**
 * Класс генерирующий исключение
 */
public class Exclusion {

    /**
     * Главная функция
     *
     * @param args
     */
    public static void main(String[] args) {
        catchesException(true);
        catchesException(null);
    }

    /**
     * Метод генерирующий исключение
     *
     * @param condition
     * @throws Exception
     */
    private static void generateException(Boolean condition) throws Exception {
        if (condition == null) {
            throw new Exception("Генерация исключения");
        }
    }

    /**
     * Метод перехватывает исключение
     *
     * @param condition
     */
    private static void catchesException(Boolean condition) {
        boolean check = false;
        try {
            generateException(condition);
        } catch (Exception e) {
            System.out.println(e);
            check = true;
        } finally {
            if (check == true) System.out.println("Объект исключения был перехвачен");
        }
    }
}
