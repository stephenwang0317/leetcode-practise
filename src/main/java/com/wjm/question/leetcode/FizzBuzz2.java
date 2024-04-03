package com.wjm.question.leetcode;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzz2 {
    private int n;
    private AtomicInteger cur;

    public FizzBuzz2(int n) {
        this.n = n;
        cur = new AtomicInteger(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                while (cur.get() != i) {
                }
                printFizz.run();
                cur.getAndIncrement();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                while (cur.get() != i) {
                }
                printBuzz.run();
                cur.getAndIncrement();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                while (cur.get() != i) {
                }
                printFizzBuzz.run();
                cur.getAndIncrement();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                while (cur.get()!=i){}
                printNumber.accept(i);
                cur.getAndIncrement();
            }
        }
    }

}