package org.example.basic;

public class ThreadBasicsRunner{

    public static void main(String[] args) throws InterruptedException {

        //Thread states -
        //NEW
        //RUNNABLE
        //RUNNING
        //BLOCKED/WAITING
        //TERMINATED

        //Thread A
        ThreadA threadA= new ThreadA();
        threadA.setPriority(10); // setting highest priority
        threadA.setName("threadA");
        threadA.start(); // thread state- NEW

        //Thread B
        ThreadBRunnable threadBRunnable= new ThreadBRunnable();
        Thread threadB = new Thread(threadBRunnable,"threadB");
        threadB.setPriority(1); //setting lowest priority
        threadB.start(); // thread state- NEW

        //wait for thread A to completed
        threadA.join();
        //main thread
        System.out.println("\n"+Thread.currentThread().getName()+" thread started");
        for(int i=200;i<=299;i++) {
            System.out.print(i + " ");
        }
        System.out.println("\nMain thread completed");// thread state- TERMINATED


    }
}
