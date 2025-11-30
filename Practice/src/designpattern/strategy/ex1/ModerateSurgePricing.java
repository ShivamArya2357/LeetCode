package Practice.src.designpattern.strategy.ex1;

import java.util.Random;

public class ModerateSurgePricing implements SurgePricingBehaviour {

    @Override
    public double getSurgeMultiplier() {
        return new Random(30).nextDouble();
    }
}
