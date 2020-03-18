package threadTest;

public class ThreadFromFirstToHundred extends Thread {
    public static int index = 0;

    @Override
    public void run() {
        int ind = 0;
        synchronized (ThreadFromFirstToHundred.class) {
            ind = ThreadFromFirstToHundred.index;
            ThreadFromFirstToHundred.index += 1;
        }
        System.out.println("this thread is " + this.getName() + " the index of it is " + ind);
        try {
            sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("thread " + this.getName() + " is over");
    }

    public static void main(String[] args) {
        Thread[] threads = new ThreadFromFirstToHundred[100];
        for (int i = 0; i < 100; i++) {
            threads[i] = new ThreadFromFirstToHundred();
            threads[i].setName("thread-" + i);
        }
        for (int i = 0; i < 100; i++) {
            threads[i].start();
        }
    }
}
