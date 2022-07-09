import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;


public class Main {
    public static void main(String[] args) {
        ForkJoinPool fjp = new ForkJoinPool();

        int arrSize = 1_500_000_000;
        int[] arr = new int[arrSize];
        //Заполняем массив единицами
        Arrays.fill(arr, 1);

        long startTime = System.currentTimeMillis();
        int arrSumm = 0;
        for (int i = 0; i < arr.length; i++) {
            arrSumm += arr[i];
        }
        long finishTime = System.currentTimeMillis();
        System.out.printf("Размер: %d%nВремя выполнения (1 поток), мс: %d%n", arrSize, finishTime - startTime);
        System.out.println();

        long startTime2 = System.currentTimeMillis();
        ArraySumCalc asc = new ArraySumCalc(0, arr.length, arr, 50_000_000);
        int res = fjp.invoke(asc);
        long finishTime2 = System.currentTimeMillis();
        System.out.printf("Размер: %d%nВремя выполнения (ForkJoinPool), мс: %d%n", arrSize, finishTime2 - startTime2);
        System.out.printf("Сумма массива: %d", res);

    }
}
