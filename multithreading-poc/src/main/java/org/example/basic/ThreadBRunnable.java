package org.example.basic;

public class ThreadBRunnable implements Runnable{

    @Override
    public void run() {
        System.out.println("\n"+Thread.currentThread().getName()+" started");
        for(int i=100;i<=199;i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nThread B completed");
    }
}
