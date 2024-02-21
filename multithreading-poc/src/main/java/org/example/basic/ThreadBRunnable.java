package org.example.basic;

public class ThreadBRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("\n"+Thread.currentThread().getName()+" started");
        for(int i=150;i<=299;i++) {
            System.out.print(Thread.currentThread().getName()+"::"+i + " ");
        }
        System.out.println("\nThread B completed");
    }
}
