package com.wjm.question.leetcode;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;

class FooBar {
    private int n;

    public FooBar(int n) {
        this.n = n;
    }

    Semaphore a = new Semaphore(1);
    Semaphore b = new Semaphore(0);


    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            a.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            b.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            b.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            a.release();
        }
    }
}