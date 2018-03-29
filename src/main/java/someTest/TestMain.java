package someTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestMain {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService threads = Executors.newFixedThreadPool(10);
        for (int j = 0; j < 10000; j++) {
//            Statistics.tolTaskNum = 0;
//            Statistics.tolSenSuccessNum = 0;
//            Statistics.tolSenFailNum = 0;
            for (int i = 0; i < 1000; i++) {
                threads.submit(new Run(10));
            }
//            Thread.sleep(100);
//            System.out.println(j + " synchronized =tolTaskNum:" + Statistics.tolTaskNum);
//            System.out.println(j + " volatile = tolSenSuccessNum:" + Statistics.tolSenSuccessNum);
//            System.out.println(j + " static = tolSenFailNum:" + Statistics.tolSenFailNum);
        }
        Thread.sleep(5000);
        System.out.println("tolTaskNum======" + Statistics.tolTaskNum);
        System.out.println("tolSenSuccessNum======" + Statistics.tolSenSuccessNum);
        System.out.println("tolSenFailNum======" + Statistics.tolSenFailNum);


    }

    static class Run implements Runnable {
        private int a = 0;

        public Run(int a) {
            this.a = a;
        }

        @Override
        public void run() {
//            System.out.println(a);
//            try {
//                Thread.sleep(100);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            Statistics.inc(a);
            Statistics.tolSenSuccessNum += a;
            Statistics.tolSenFailNum += a;

        }
    }
}
