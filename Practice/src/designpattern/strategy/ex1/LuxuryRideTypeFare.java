package Practice.src.designpattern.strategy.ex1;

public class LuxuryRideTypeFare implements RideTypeFareBehaviour {

    @Override
    public double getBaseFare() {
        return 350.0;
    }
}
