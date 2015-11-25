package ru.artezio.task5;

/**
 * Класс реализующий выбор 15 неповторяющихся вопросов
 */
public class Task5 {

    /**
     * Количсетво строк в таблице=количество вопросов
     */
    public static final int SIZE_EXAMPLES = 15;

    /**
     * Количество стобцов для сохранения вопросов
     * 2 множителя+ произведение
     */
    public static final int SIZE_COL = 3;

    /**
     * Максимальное цифра одного из множителей
     */
    public static final int MAX_VALUE_MULTI = 9;

    /**
     * Минимальная  цифра одного из множителей
     */
    public static final int MIN_VALUE_MULTI = 2;

    /**
     * Индекс 1 множителя в массиве
     */
    public static final int INDEX_FIRST_NUMBER_MULTI = 0;

    /**
     * Индекс 2 множителя в массиве
     */
    public static final int INDEX_SECOND_NUMBER_MULTI = 1;

    /**
     * Индекс произведения в массиве
     */
    public static final int INDEX_MULTIPLICATION = 2;

    /**
     * Главный метод
     *
     * @param args
     */
    public static void main(String[] args) {
        int[][] arrayExamples = new int[SIZE_EXAMPLES][SIZE_COL];
        filling(arrayExamples);
        show(arrayExamples);
    }

    /**
     * Заполнение массива
     *
     * @param array массив поступающий  для заполнения
     */
    private static void filling(int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length - 1; j++) {
                array[i][j] = (int) (Math.random() * (MAX_VALUE_MULTI - MIN_VALUE_MULTI + 1)) + MIN_VALUE_MULTI;
            }
            array[i][INDEX_MULTIPLICATION] = array[i][INDEX_FIRST_NUMBER_MULTI] * array[i][INDEX_SECOND_NUMBER_MULTI];
            if (checkRepeat(array, i)) {
                i--;
            }
        }
    }

    /**
     * Выводит массив
     *
     * @param array массив
     */
    private static void show(int[][] array) {
        System.out.println("Массив:");
        for (int[] row : array) {
            System.out.printf("%d*%d=%d\n", row[INDEX_FIRST_NUMBER_MULTI], row[INDEX_SECOND_NUMBER_MULTI],
                    row[INDEX_MULTIPLICATION]);
        }
    }

    /**
     * Проверка на повторения
     *
     * @param array массив
     * @param count число строк которые заполнены
     */
    private static boolean checkRepeat(int[][] array, int count) {
        for (int i = 0; i < count; i++) {
            if ((array[count][INDEX_MULTIPLICATION] == array[i][INDEX_MULTIPLICATION])
                    && ((array[count][INDEX_FIRST_NUMBER_MULTI] == array[i][INDEX_FIRST_NUMBER_MULTI])
                    || (array[count][INDEX_SECOND_NUMBER_MULTI] == array[i][INDEX_FIRST_NUMBER_MULTI])))
                return true;
        }
        return false;
    }
}