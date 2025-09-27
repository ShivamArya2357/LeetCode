package Practice.src.designpattern.strategy.ex1;

public class LuxuryRide extends Ride {

    public LuxuryRide() {
        super(new LuxuryRideTypeFare(), new HighSurgePricing(), new LoyaltyDiscount());
    }

    @Override
    public void display() {
        System.out.println("LuxuryRide journey");
    }
}
