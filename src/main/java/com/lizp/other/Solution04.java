package com.lizp.other;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Solution04 {
    private static int count = 0;

    public static void main(final String[] args) {
        int count = 0;
        ReentrantLock lock = new ReentrantLock();
        new Thread(new PrintNum(lock, 10, 0)).start();
        new Thread(new PrintNum(lock, 10, 1)).start();
        new Thread(new PrintNum(lock, 10, 2)).start();
    }

    static class PrintNum implements Runnable {
        private Lock lock;
        private int printTimes;
        private int order;

        public PrintNum(Lock lock, int printTimes, int order) {
            this.lock = lock;
            this.printTimes = printTimes;
            this.order = order;
        }

        @Override
        public void run() {
            for (int i = 1; i <= printTimes; ) {
                lock.lock();
                try {
                    if (count % 3 == order) {
                        System.err.print((char) (order + 'A'));
                        count++;
                        i++;
                    }
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}


