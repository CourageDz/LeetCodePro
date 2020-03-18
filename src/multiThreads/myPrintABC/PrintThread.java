package multiThreads.myPrintABC;

public class PrintThread implements Runnable {
    private static volatile int item = 0;
    private int threadNum;
    private int threadCount;
    private Object object;
    private char c;
    private int count;

    public PrintThread(int threadNum, int threadCount, Object object, char c, int count) {
        this.threadNum = threadNum;
        this.threadCount = threadCount;
        this.object = object;
        this.c = c;
        this.count = count;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (object) {
                while (item % threadCount != threadNum) {
                    try {
                        object.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

                System.out.println("threadNum:=" + threadNum + " " + count + " " + c);
                item++;
                System.out.println("item=" + item);
                count--;
                object.notifyAll();
                if (count == 0) {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Object object = new Object();
        Thread t1 = new Thread(new PrintThread(0, 3, object, 'A', 10));
        Thread t2 = new Thread(new PrintThread(1, 3, object, 'B', 10));
        Thread t3 = new Thread(new PrintThread(2, 3, object, 'C', 10));
        t1.start();
        t2.start();
        t3.start();

    }
}
