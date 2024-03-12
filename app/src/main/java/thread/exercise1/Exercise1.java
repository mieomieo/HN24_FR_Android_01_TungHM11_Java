package thread.exercise1;

import java.util.Random;

public class Exercise1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        while (true) {
            int n = rnd.nextInt(20) + 1;
            MyThread1 thread1 = new MyThread1();
            thread1.setN(n);
            Thread t1 = new Thread(thread1);
            MyThread2 thread2 = new MyThread2();
            thread2.setN(n);
            Thread t2 = new Thread(thread2);

            t1.start();
            try {
                Thread.sleep(2000);
                t2.start();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                t1.join();
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread1 implements Runnable {
    protected int n;

    @Override
    public void run() {
        createNumber();
    }

    public void createNumber() {
        int i = getN();
        System.out.println("So: " + i);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ;

    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }
}

class MyThread2 extends MyThread1 implements Runnable {
    @Override
    public void run() {
        squareNumber();
    }

    @Override
    public void setN(int n) {
        super.setN(n);
    }

    private void squareNumber() {
        int i = getN();
        System.out.println("So binh phuong: " + i * i);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        ;
    }
}
