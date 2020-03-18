package threadTest.serialPrint;

public class PrintThread implements Runnable {
    private static final Object lock = new Object();
    private int max;
    private int thradNo;
    private int threadCount;
    private static int current = 0;

    public PrintThread(int max, int thradNo, int threadCount) {
        this.max = max;
        this.thradNo = thradNo;
        this.threadCount = threadCount;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                while (current % threadCount != thradNo) {
                    if (current > max) {
                        break;
                    }
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (current > max) {
                    break;
                }
                System.out.println("thread-" + thradNo + ":" + current);
                current++;
                lock.notifyAll();
            }
        }

    }

    public static void main(String[] args) {
        int threadCount = 3;
        int max = 20;
        for (int i = 0; i < threadCount; i++) {
            new Thread(new PrintThread(max, i, threadCount)).start();
        }
    }
}
