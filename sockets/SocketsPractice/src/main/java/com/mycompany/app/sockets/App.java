package com.mycompany.app.sockets;

public class App 
{
    public static void main( String[] args )
    {
        
        RyanAndMonicaJob theJob = new App().getRyanAndMonicaJob();
        theJob.setAmount(10);
        Thread one = new Thread(theJob);
        Thread two = new Thread(theJob);
        one.setName("Ryan Thread");
        two.setName("Monica Thread");
        one.start();
        two.start(); 
        
    }

    public static class MyRunnable implements Runnable {
        @Override
        public void run() {
            for (int i = 0; i < 25; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println(threadName.concat(" is runnnig"));
            }
        }

        public void go() {
            doMore();
        }

        public void doMore() {
            System.out.println("Do More");
        }
    }

    public class RyanAndMonicaJob implements Runnable 
    {
        private BankAccount account;
        public final int INVALID_VALUE = -1;
        private int amount;
        public RyanAndMonicaJob() {
            account = new BankAccount(3000);
        }

        //Bank Account Class
        class BankAccount {
            private int balance;

            public BankAccount(int balance) {
                this.balance = balance;
            }
            public int getBalance() {
                return balance;
            }

            public synchronized int withdraw(int amount) {
                if (amount <= balance) {
                    System.out.println(Thread.currentThread().getName() + " is about to withdraw");
                    try {
                        System.out.println(Thread.currentThread().getName() + " is going to sleep");
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        ex.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " woke up.");
                    balance = balance - amount;
                
                    return amount;
                }
                return -1;
            }

            public void saySomething() {
                System.out.println("Im saying");
                 
                synchronized(this) {
                    System.out.println("Critical Stuff");
                    System.out.println("More Critical Stuff");
                }
            }

            //End of BankAccount Class
        }

        public void setAmount(int amount) {
            this.amount = amount;
        }

        @Override 
        public void run() {
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(2000);
                    account.saySomething();
                    int resultValue = account.withdraw(amount);
                    if (resultValue != INVALID_VALUE) 
                        System.out.println(Thread.currentThread().getName() + " completes hte withdrawl");
                     
                    else 
                        System.out.println("Sorry, not enough for" + Thread.currentThread().getName());

                } catch (InterruptedException ex) { 
                    ex.printStackTrace();
                }
            }    
        }        
    }

    public RyanAndMonicaJob getRyanAndMonicaJob() {
        return new RyanAndMonicaJob();
    }
}
