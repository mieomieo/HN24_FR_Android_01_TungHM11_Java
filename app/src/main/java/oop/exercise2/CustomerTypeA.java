package oop.exercise2;

public class CustomerTypeA extends Customer{

    public CustomerTypeA(int quantity, double price) {
        super(quantity, price);

    }
    @Override
    public double calcPrice(){
        return super.calcPrice()*(1+taxVAT);
    }

}
