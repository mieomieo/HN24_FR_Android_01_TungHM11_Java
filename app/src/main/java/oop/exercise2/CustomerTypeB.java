package oop.exercise2;

public class CustomerTypeB extends Customer{
    private int loyaltyYear;
    public CustomerTypeB(int quantity, double price, int loyaltyYear){
        super(quantity,price);
        this.loyaltyYear = loyaltyYear;
    }

    @Override
    public double calcPrice(){
        double discount = Math.min(loyaltyYear*0.05,0.5);
        return super.calcPrice()*(1-discount)*(1+taxVAT);
    }
}
