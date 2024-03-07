package oop.exercise3;

public class DeluxeRoom extends Room{
    public DeluxeRoom( int numberOfNightsSpent,double serviceFee){
        super("Deluxe",numberOfNightsSpent,serviceFee);
    }
    @Override
    public double calcRevenue(){
        return (numberOfNightsSpent * 750000 + serviceFee) * 1.05;
    }
}
