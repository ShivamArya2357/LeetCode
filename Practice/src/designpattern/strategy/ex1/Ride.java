package Practice.src.designpattern.strategy.ex1;

public abstract class Ride {

    private RideTypeFareBehaviour rideTypeFareBehaviour;

    private SurgePricingBehaviour surgePricingBehaviour;

    private DiscountBehaviour discountBehaviour;

    public Ride(RideTypeFareBehaviour rideTypeFareBehaviour, SurgePricingBehaviour surgePricingBehaviour,
                DiscountBehaviour discountBehaviour
    ) {
        this.rideTypeFareBehaviour = rideTypeFareBehaviour;
        this.surgePricingBehaviour = surgePricingBehaviour;
        this.discountBehaviour = discountBehaviour;
    }

    public void setRideTypeFareBehaviour(RideTypeFareBehaviour rideTypeFareBehaviour) {
        this.rideTypeFareBehaviour = rideTypeFareBehaviour;
    }

    public void setSurgePricingBehaviour(SurgePricingBehaviour surgePricingBehaviour) {
        this.surgePricingBehaviour = surgePricingBehaviour;
    }

    public void setDiscountBehaviour(DiscountBehaviour discountBehaviour) {
        this.discountBehaviour = discountBehaviour;
    }

    public double calculateRideFare() {
        return rideTypeFareBehaviour.getBaseFare() * surgePricingBehaviour.getSurgeMultiplier() -
                discountBehaviour.getDiscount();
    }

    public abstract void display();
}
