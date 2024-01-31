package org.example.basic;

public class ThreadA extends Thread{

    public void run() {
        System.out.println("\nThread A started");
        for(int i=0;i<=99;i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nThread A completed");
    }
}
