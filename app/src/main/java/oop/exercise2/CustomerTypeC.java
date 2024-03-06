package oop.exercise2;

public class CustomerTypeC extends Customer{
    public CustomerTypeC(int quantity,double price){
        super(quantity,price);
    }
    @Override
    public double calcPrice(){
        return super.calcPrice()*0.5*(1+taxVAT);
    }
}
