package com.mycompany.app.sockets;


public class App 
{
    public static void main( String[] args )
    {
        App app = new App();
        Runnable threadJob = new MyRunnable();
        Thread thread = new Thread(threadJob);
        thread.start();
        
        System.out.println("Back in main");
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            doMore();
        }

        public void go() {
            doMore();
        }

        public void doMore() {
            System.out.println("Do More");
        }
    }
}
