package com.wjm.question.leetcode;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

class ZeroEvenOdd {
    private int n;
    Semaphore zero;
    Semaphore even0;
    Semaphore even;
    Semaphore odd;

    public ZeroEvenOdd(int n) {
        this.n = n;
        zero = new Semaphore(1);
        even = new Semaphore(0);
        odd = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            zero.acquire();
            printNumber.accept(0);
            if (i % 2 != 0) {
                odd.release();
            } else {
                even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 0) {
                even.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0) {
                odd.acquire();
                printNumber.accept(i);
                zero.release();
            }
        }
    }

    public static void main(String[] args) {
        ZeroEvenOdd z = new ZeroEvenOdd(5);
        new Thread(() -> {
            try {
                z.zero(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                z.even(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                z.odd(System.out::print);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}