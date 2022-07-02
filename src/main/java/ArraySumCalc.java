import java.util.concurrent.RecursiveAction;
import java.util.concurrent.RecursiveTask;

public class ArraySumCalc extends RecursiveTask<Integer> {

    int start;
    int end;
    int[] arr;
    int threshold;

    public ArraySumCalc(int start, int end, int[] arr, int threshold) {
        this.start = start;
        this.end = end;
        this.arr = arr;
        this.threshold = threshold;
    }

    @Override
    protected Integer compute() {
        int summ = 0;
        if (Math.abs(end - start) <= threshold) {
            for (int i = start; i < end; i++) {
                summ += arr[i];
            }
        } else {
            final int mid = (end - start) / 2 + start;
            ArraySumCalc task1 = new ArraySumCalc(start, mid, arr, threshold);
            ArraySumCalc task2 = new ArraySumCalc(mid, end, arr, threshold);
            invokeAll(task1, task2);
            summ += task1.join() + task2.join();
        }
        return summ;
    }

//    private int forkTaskAndGetResult() {
//
//    }
}
