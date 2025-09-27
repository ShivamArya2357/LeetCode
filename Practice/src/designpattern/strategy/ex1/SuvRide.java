package Practice.src.designpattern.strategy.ex1;

public class SuvRide extends Ride {

    public SuvRide() {
        super(new SuvRideTypeFare(), new ModerateSurgePricing(), new NoDiscount());
    }

    @Override
    public void display() {
        System.out.println("SuvRide journey");
    }
}
