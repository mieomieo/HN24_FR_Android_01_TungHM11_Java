package oop.exercise2;

public  class Customer {

    protected int quantity;
    protected double price;
    protected final double taxVAT = 0.1;

    public Customer(int quantity,double price){
        this.quantity=quantity;
        this.price = price;
    }
    public double calcPrice(){
        return quantity*price;
    }
}
