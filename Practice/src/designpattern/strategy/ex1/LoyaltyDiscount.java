package Practice.src.designpattern.strategy.ex1;

public class LoyaltyDiscount implements DiscountBehaviour {

    @Override
    public double getDiscount() {
        return 15.0;
    }
}
