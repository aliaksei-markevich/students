package ru.artezio.task5;

public class Main {

    public static final int SIZE_EXAMPLES = 15;
    public static final int SIZE_COL = 3;
    public static final int MAX_VALUE_MULTI = 9;
    public static final int MIN_VALUE_MULTI = 2;
    public static final int INDEX_FIRST_NUMBER_MULTI = 0;
    public static final int INDEX_SECOND_NUMBER_MULTI = 1;
    public static final int INDEX_MULTIPLICATION = 2;

    public static void main(String[] args) {
        int[][] arrayExamples = new int[SIZE_EXAMPLES][SIZE_COL];
        filling(arrayExamples);
        show(arrayExamples);
    }

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

    private static void show(int[][] array) {
        System.out.println("Массив:");
        for (int[] row : array) {
            System.out.printf("%d*%d=%d\n", row[INDEX_FIRST_NUMBER_MULTI], row[INDEX_SECOND_NUMBER_MULTI],
                                row[INDEX_MULTIPLICATION]);
        }
    }

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