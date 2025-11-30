package Practice.src.designpattern.strategy.ex1;

public class MiniRideTypeFare implements RideTypeFareBehaviour {

    @Override
    public double getBaseFare() {
        return 110.0;
    }
}
