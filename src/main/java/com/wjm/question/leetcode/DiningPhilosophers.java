package com.wjm.question.leetcode;

import java.util.concurrent.Semaphore;

class DiningPhilosophers {
    Semaphore[] forks;
    int[][] map;

    public DiningPhilosophers() {
        forks = new Semaphore[]{
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1),
                new Semaphore(1)};
        map = new int[][]{
                new int[]{0, 1},
                new int[]{1, 2},
                new int[]{2, 3},
                new int[]{3, 4},
                new int[]{4, 0},
        };

    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {
        int left = map[philosopher][0], right = map[philosopher][1];
        if (philosopher % 2 == 0) {
            forks[left].acquire();
            forks[right].acquire();
        } else {
            forks[right].acquire();
            forks[left].acquire();
        }
        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putRightFork.run();
        putLeftFork.run();
        forks[right].release();
        forks[left].release();

    }
}