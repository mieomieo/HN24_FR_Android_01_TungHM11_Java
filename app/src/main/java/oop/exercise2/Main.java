package oop.exercise2;

public class Main {
    public static void main(String[] args) {

        Customer[] customerList = {
                new CustomerTypeA(100, 50000),
                new CustomerTypeB(200, 50000, 5),
                new CustomerTypeC(50, 100000)
        };

        double totalPriceOfCustomer = 0;
        for (Customer khachHang : customerList) {
            double amountPayment = khachHang.calcPrice();
            totalPriceOfCustomer += amountPayment;
            System.out.println("Số tiền phải trả của khách hàng: " + amountPayment);
        }

        System.out.println("Tổng số tiền công ty thu được: " + totalPriceOfCustomer);
    }
}
