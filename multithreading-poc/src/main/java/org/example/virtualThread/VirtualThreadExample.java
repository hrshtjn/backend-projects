package org.example.virtualThread;

public class VirtualThreadExample {


    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = () -> {
            System.out.println("\n"+Thread.currentThread().getName()+" started");
            for(int i=100;i<=199;i++) {
                System.out.print(i + " ");
            }
            System.out.println("\n"+Thread.currentThread().getName()+" completed");
        };

        Thread vThread = Thread.ofVirtual().start(runnable);
        vThread.setName("vThread");
        vThread.join();
        Thread vThreadUnstarted =Thread.ofVirtual().unstarted(runnable);
        vThreadUnstarted.setName("vThreadUnstarted");

        vThreadUnstarted.start();
        vThreadUnstarted.join();



    }
}
