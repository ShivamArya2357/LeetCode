package Practice.src.designpattern.strategy.ex1;

import java.util.Random;

public class HighSurgePricing implements SurgePricingBehaviour {

    @Override
    public double getSurgeMultiplier() {
        return new Random(150).nextDouble();
    }
}
