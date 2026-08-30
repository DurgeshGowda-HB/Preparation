package OS;

import java.util.concurrent.locks.*;

class print_order {

    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    private int turn = 0;

    public void first(Runnable printFirst) {
    //lock 1
        lock.lock();

        try {

            printFirst.run();

            turn = 1;

            condition.signalAll();

        } finally {

            lock.unlock();

        }
    }

    public void second(Runnable printSecond)
            throws InterruptedException {
// lock 2
        lock.lock();

        try {

            while(turn != 1){

                condition.await();

            }

            printSecond.run();

            turn = 2;

            condition.signalAll();

        } finally {

            lock.unlock();

        }
    }

    public void third(Runnable printThird)
            throws InterruptedException {
// lock 3
        lock.lock();

        try {

            while(turn != 2){

                condition.await();

            }

            printThird.run();

        } finally {

            lock.unlock();

        }
    }
}
