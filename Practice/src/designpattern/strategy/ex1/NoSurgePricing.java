package Practice.src.designpattern.strategy.ex1;

public class NoSurgePricing implements SurgePricingBehaviour {

    @Override
    public double getSurgeMultiplier() {
        return 0;
    }
}
