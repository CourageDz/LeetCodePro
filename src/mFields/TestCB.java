package mFields;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestCB {
    class command implements Runnable {

        @Override
        public void run() {
            try {
                System.out.println("Current Thread" + Thread.currentThread().getName() + " before Start");
                Thread.sleep(1000);
                System.out.println("Current Thread" + Thread.currentThread().getName() + " after Start");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        TestCB testCB = new TestCB();
        ExecutorService executorService = Executors.newCachedThreadPool();
        final CyclicBarrier cyclicBarrier = new CyclicBarrier(4, testCB.new command());
        for (int i = 0; i < 4; i++) {
            executorService.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println("Current Thread " + Thread.currentThread().getName() + " Starts");
                        Thread.sleep(1000);
                        cyclicBarrier.await();
                        System.out.println("Current Thread" + Thread.currentThread().getName() + " end");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
