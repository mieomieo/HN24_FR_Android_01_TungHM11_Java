package thread.exercise3;
import java.util.concurrent.ThreadLocalRandom;
public class Exercise3 {
    public static void main(String[] args) {
        Data data = new Data();
        Thread t1 = new Thread(new MyThread01(data));
        Thread t2 = new Thread(new MyThread02(data));
        t1.start();
        t2.start();
    }
}

class Data {
    private int total;
    public synchronized int getTotal() {
        return total;
    }
    public synchronized void addToTotal(int value) {
        total += value;
    }
    public synchronized boolean isOverThreshold() {
        return total <= -100 || total >= 100;
    }
}

class MyThread01 implements Runnable {
    private final Data data;
    public MyThread01(Data data) {
        this.data = data;
    }
    @Override
    public void run() {
        while (!data.isOverThreshold()) {
            int randomNum = ThreadLocalRandom.current().nextInt(-100, 1);
            data.addToTotal(randomNum);
            System.out.println("Thread 1 - Total: " + data.getTotal());
        }
    }
}

class MyThread02 implements Runnable {
    private final Data data;
    public MyThread02(Data data) {
        this.data = data;
    }
    @Override
    public void run() {
        while (!data.isOverThreshold()) {
            int randomNum = ThreadLocalRandom.current().nextInt(0, 101);
            data.addToTotal(randomNum);
            System.out.println("Thread 2 - Total: " + data.getTotal());
        }
    }
}
