package multiThreads.serialPrintABC;

public class PrintThread implements Runnable {
    private char printChar;
    private Object pre;
    private Object now;
    private int count;

    public PrintThread(char printChar, Object pre, Object now, int count) {
        this.printChar = printChar;
        this.pre = pre;
        this.now = now;
        this.count = count;
    }

    @Override
    public void run() {
        for (int i = 0; i < count; i++) {
            synchronized (pre) {
                synchronized (now) {
                    System.out.println(i + " " + printChar);
                    now.notifyAll();

                }

                if (i < count - 1) {
                    try {
                        pre.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Object o1 = new Object();
        Object o2 = new Object();
        Object o3 = new Object();

        PrintThread t1 = new PrintThread('A', o3, o1, 10);
        PrintThread t2 = new PrintThread('B', o1, o2, 10);
        PrintThread t3 = new PrintThread('C', o2, o3, 10);
        Thread tt1 = new Thread(t1);
        Thread tt2 = new Thread(t2);
        Thread tt3 = new Thread(t3);
        tt1.start();
        tt2.start();
        try {
            tt2.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
        tt3.start();
        try {
            tt3.sleep(100);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
