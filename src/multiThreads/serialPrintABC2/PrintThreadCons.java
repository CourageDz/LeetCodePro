package multiThreads.serialPrintABC2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class PrintThreadCons implements Runnable {
    private static ReentrantLock lock = new ReentrantLock();
    private Condition pre;
    private Condition now;
    private char c;
    private int count;

    public PrintThreadCons(Condition pre, Condition now, char c, int count) {
        this.pre = pre;
        this.now = now;
        this.c = c;
        this.count = count;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            for (int i = 0; i < count; i++) {
                System.out.println(i + " " + c);
                now.signal();
                if (i < count - 1) {
                    try {
                        pre.await();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } finally {
            lock.unlock();
        }

    }

    public static void main(String[] args) throws InterruptedException {
        Condition con1 = lock.newCondition();
        Condition con2 = lock.newCondition();
        Condition con3 = lock.newCondition();
        Thread t1 = new Thread(new PrintThreadCons(con1, con2, 'A', 10));
        Thread t2 = new Thread(new PrintThreadCons(con2, con3, 'B', 10));
        Thread t3 = new Thread(new PrintThreadCons(con3, con1, 'C', 10));
        t1.start();
        Thread.sleep(100);
        t2.start();
        Thread.sleep(100);
        t3.start();


    }
}
