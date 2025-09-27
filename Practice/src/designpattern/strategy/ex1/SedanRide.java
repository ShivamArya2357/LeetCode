package Practice.src.designpattern.strategy.ex1;

public class SedanRide extends Ride {

    public SedanRide() {
        super(new SedanRideTypeFare(), new NoSurgePricing(), new PromoCodeDiscount());
    }

    @Override
    public void display() {
        System.out.println("SedanRide journey");
    }
}
