package oop.exercise3;

class PremiumRoom extends Room {
    public PremiumRoom(int numberOfNightsSpent, double serviceFee) {
        super("Premium", numberOfNightsSpent, serviceFee);
    }

    @Override
    public double calcRevenue() {
        return (numberOfNightsSpent * 500000 + serviceFee) * 1.05;
    }
}