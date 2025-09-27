package Practice.src.designpattern.strategy.ex1;

public class NoDiscount implements DiscountBehaviour {

    @Override
    public double getDiscount() {
        return 0;
    }
}
