package Practice.src.designpattern.strategy.ex1;

public class MiniRide extends Ride {

    public MiniRide() {
        super(new MiniRideTypeFare(), new NoSurgePricing(), new NoDiscount());
    }

    @Override
    public void display() {
        System.out.println("MiniRide journey");
    }
}
