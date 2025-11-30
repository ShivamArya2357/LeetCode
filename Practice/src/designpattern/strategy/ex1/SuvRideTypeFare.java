package Practice.src.designpattern.strategy.ex1;

public class SuvRideTypeFare implements RideTypeFareBehaviour {

    @Override
    public double getBaseFare() {
        return 230.0;
    }
}
