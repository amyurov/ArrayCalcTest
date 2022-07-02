//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//import java.util.concurrent.ForkJoinPool;
//import java.util.concurrent.RecursiveAction;
//
//public class Starter {
//    public static void main(String[] args) {
//        final int MAX = 64;
//        ExecutorService fjp = Executors.newWorkStealingPool();
//        fjp.submit(new MyAction(MAX));
//        System.out.println("FINISH");
//
//    }
//}
//
//class MyAction extends RecursiveAction {
//
//    private int value;
//
//    public MyAction(int value) {
//        this.value = value;
//    }
//
//    @Override
//    protected void compute() {
//        if(value <= 4) {
//            System.out.printf("Hello before %d %d %n",Thread.currentThread().getId(), value);
//            try {
//                Thread.sleep(2000);
//            } catch (InterruptedException e) {
//            }
//            System.out.printf("Hello after %d %d %n",Thread.currentThread().getId(), value);
//        } else {
//            MyAction m1 = new MyAction(value/2);
//            MyAction m2 = new MyAction(value/2);
//            invokeAll(m1,m2);
//        }
//    }
//}
