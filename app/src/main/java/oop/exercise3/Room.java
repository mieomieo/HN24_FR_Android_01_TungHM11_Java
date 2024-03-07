package oop.exercise3;

public abstract class Room {
    protected String type;
    protected int numberOfNightsSpent;
    protected double serviceFee;
    public Room(String type, int numberOfNightsSpent,double serviceFee){
        this.type = type;
        this.numberOfNightsSpent = numberOfNightsSpent;
        this.serviceFee = serviceFee;
    }
    public String getType(){
        return type;
    }
    public abstract double calcRevenue();

}
