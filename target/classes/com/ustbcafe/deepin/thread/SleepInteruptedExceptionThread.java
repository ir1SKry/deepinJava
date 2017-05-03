package com.ustbcafe.deepin.thread;

/**
 * Created by Rudy Steiner on 2017/1/4.
 */
public class SleepInteruptedExceptionThread {

    public static void main(String[] args) throws  InterruptedException{
        Thread t1 = new Thread() {
            public void run() {
                while (true) {
                    if (Thread.currentThread().isInterrupted()) {
                        System.out.println("interupted!");
                        break;
                    }

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ite) {
                        System.out.println("interupted when sleep!");
                        Thread.currentThread().interrupt();
                    }
                    Thread.yield();
                }
            }
        };
        t1.start();
        Thread.sleep(2000);
        t1.interrupt();
    }
}
