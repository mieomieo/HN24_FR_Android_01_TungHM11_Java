package thread.exercise2;

import java.util.concurrent.ThreadLocalRandom;

public class Exercise2 {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();
        Thread t1 = new Thread(new MyThread1(sharedData));
        Thread t2 = new Thread(new MyThread2(sharedData));

        t1.start();
        t2.start();

        // Đợi 20 giây trước khi kết thúc chương trình
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Kết thúc các thread
        sharedData.setStop(true);
    }
}

class SharedData {
    private char generatedChar;
    private boolean stop;

    public synchronized char getGeneratedChar() {
        while (generatedChar == '\0' && !stop) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        char result = generatedChar;
        generatedChar = '\0';
        notify();
        return result;
    }

    public synchronized void setGeneratedChar(char generatedChar) {
        while (this.generatedChar != '\0' && !stop) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.generatedChar = generatedChar;
        notify(); // Wake up waiting threads
    }

    public synchronized boolean isStop() {
        return stop;
    }

    public synchronized void setStop(boolean stop) {
        this.stop = stop;
        notifyAll();
    }
}

class MyThread1 implements Runnable {
    private final SharedData sharedData;

    public MyThread1(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (!sharedData.isStop()) {
            char randomChar = (char) (ThreadLocalRandom.current().nextInt('a', 'z' + 1));
            sharedData.setGeneratedChar(randomChar);
            System.out.println("Thread 1 - Sinh ký tự: " + randomChar);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class MyThread2 implements Runnable {
    private final SharedData sharedData;

    public MyThread2(SharedData sharedData) {
        this.sharedData = sharedData;
    }

    @Override
    public void run() {
        while (!sharedData.isStop()) {
            char generatedChar = sharedData.getGeneratedChar();
            char upperCaseChar = Character.toUpperCase(generatedChar);
            System.out.println("Thread 2 - Ký tự hoa: " + upperCaseChar);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
