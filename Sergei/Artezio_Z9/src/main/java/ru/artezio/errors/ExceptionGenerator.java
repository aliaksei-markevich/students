package ru.artezio.errors;

/**
 * Класс генерирующий исключение
 */
public class ExceptionGenerator {

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
    private static void generateException(Boolean condition) throws MyException {
        if (condition == null) {
            throw new MyException("Генерация ошибки: нулевая ссылка");
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
        } catch (MyException e) {
            System.out.println(e);
            check = true;
        } finally {
            if (check == true) System.out.println("Объект исключения был перехвачек");
        }
    }
}
