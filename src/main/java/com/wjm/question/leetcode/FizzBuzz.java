package com.wjm.question.leetcode;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

class FizzBuzz {
    private int n;
    Semaphore fizz;
    Semaphore buzz;
    Semaphore fb;
    Semaphore num;


    public FizzBuzz(int n) {
        this.n = n ;
        fizz = new Semaphore(0);
        buzz = new Semaphore(0);
        fb = new Semaphore(0);
        num = new Semaphore(1);
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 != 0) {
                fizz.acquire();
                printFizz.run();
                num.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 == 0) {
                buzz.acquire();
                printBuzz.run();
                num.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 15 == 0) {
                fb.acquire();
                printFizzBuzz.run();
                num.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            if (i % 3 != 0 && i % 5 != 0) {
                num.acquire();
                printNumber.accept(i);
                num.release();
            } else {
                num.acquire();
                if (i % 15 == 0) {
                    fb.release();
                } else if (i % 3 == 0) {
                    fizz.release();
                } else {
                    buzz.release();
                }
            }
        }
    }


    public static void main(String[] args) {
        FizzBuzz fizzBuzz = new FizzBuzz(15);
        new Thread(() -> {
            try {
                fizzBuzz.fizz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("fizz");
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.buzz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("buzz");
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.fizzbuzz(new Runnable() {
                    @Override
                    public void run() {
                        System.out.println("fizzbuzz");
                    }
                });
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
        new Thread(() -> {
            try {
                fizzBuzz.number(s -> System.out.println(s));
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }).start();
    }
}