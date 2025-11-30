package Practice.src.designpattern.strategy.ex1;

public class FirstRideFreeDiscount implements DiscountBehaviour {

    @Override
    public double getDiscount() {
        return 100;
    }
}
