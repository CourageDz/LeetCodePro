package simulation0727.t2;


import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextLine()) {
            String s = sc.nextLine();
            System.out.printf(s);
            Thread previous = null;

            for (int i = 0; i < 3; i++) {
                Thread thread = new Thread(new Turn(previous, (char) ('A' + i)));
                thread.start();
                previous = thread;
            }
        }


    }

    static class Turn implements Runnable {
        private Thread thread;
        private char c;

        public Turn(Thread thread, char cc) {
            this.thread = thread;
            this.c = cc;
        }

        public void run() {
            try {
                if (thread != null) {
                    thread.join();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.printf("_" + c);
        }
    }

}
