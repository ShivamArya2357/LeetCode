package Practice.src.designpattern.strategy.ex1;

public class SedanRideTypeFare implements RideTypeFareBehaviour {

    @Override
    public double getBaseFare() {
        return 180.0;
    }
}
