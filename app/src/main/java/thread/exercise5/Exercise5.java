package thread.exercise5;

class PrintNameThread extends Thread {
    private String[] names;
    private PrintAddressThread addressThread;

    public PrintNameThread(String[] names, PrintAddressThread addressThread) {
        this.names = names;
        this.addressThread = addressThread;
    }

    @Override
    public void run() {
        for (int i = 0; i < names.length; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Thread1 - Name: " + names[i]);
            addressThread.printNextAddress();
        }
    }
}

class PrintAddressThread extends Thread {
    private String[] addresses;
    private int currentIndex = 0;
    public PrintAddressThread(String[] addresses) {
        this.addresses = addresses;
    }
    public synchronized void printNextAddress() {
        if (currentIndex < addresses.length) {
            System.out.println("Thread2 - Address: " + addresses[currentIndex]);
            currentIndex++;
        }
    }
    @Override
    public void run() {
    }
}

public class Exercise5 {
    public static void main(String[] args) {
        String[] names = {"Nguyen Van Huan", "Nguen Linh Duc", "Nguyen Van Tan", "Vu Viet Tung", "Tran Trung Nghia"};
        String[] addresses = {"Ha Noi", "Hung Yen", "Thanh hoa", "Ha Tinh", "Quang Ninh"};
        PrintAddressThread addressThread = new PrintAddressThread(addresses);
        PrintNameThread nameThread = new PrintNameThread(names, addressThread);
        nameThread.start();
    }
}
