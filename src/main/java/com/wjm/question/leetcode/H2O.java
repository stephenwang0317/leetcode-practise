package com.wjm.question.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class H2O {
    Semaphore h;
    Semaphore o;
    CyclicBarrier cb;

    public H2O() {
        h = new Semaphore(2);
        o = new Semaphore(1);
        cb = new CyclicBarrier(3, () -> {
            h.release(2);
            o.release(1);
        });
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.

        releaseHydrogen.run();
        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(1);
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        try {
            cb.await();
        } catch (BrokenBarrierException e) {
            throw new RuntimeException(e);
        }
    }

    public static void main(String[] args) {
        H2O h2O = new H2O();
        String str = "HHHHHHOHHOOO";
        new Thread(() -> {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'H') {
                    try {
                        h2O.hydrogen(() -> System.out.println('H'));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
        new Thread(() -> {
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == 'O') {
                    try {
                        h2O.oxygen(() -> System.out.println('O'));
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }
}