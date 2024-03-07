package oop.exercise3;

public class BussinessRoom extends Room{
    public BussinessRoom( int numberOfNightsSpent){
        super("Business",numberOfNightsSpent,0);
    }
    @Override
    public double calcRevenue(){
        return numberOfNightsSpent* 300000;
    }
}
