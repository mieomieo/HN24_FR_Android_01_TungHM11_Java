package thread.exercise4;

import java.util.ArrayList;
import java.util.Random;

class Thread1 extends Thread {
    ArrayList<Integer> list1 = new ArrayList<>();
    @Override
    public void run() {
        Random random = new Random();
        int count = 0;
        while (count < 10) {
            try {
                Thread.sleep(1000);
                int randomNumber = random.nextInt(101);
                list1.add(randomNumber);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Thread2 extends Thread {
    ArrayList<Character> list2 = new ArrayList<>();

    @Override
    public void run() {
        Random random = new Random();
        int count = 0;
        while (count < 10) {
            try {
                Thread.sleep(2000);
                char randomChar = (char) (random.nextInt(26) + 'a');
                list2.add(randomChar);
                count++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Exercise4 {
    public static void main(String[] args) {
        Thread1 t1 = new Thread1();
        Thread2 t2 = new Thread2();

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Thread 1 list: " + t1.list1);
        System.out.println("Thread 2 list: " + t2.list2);
    }
}
