package Practice.src.designpattern.strategy.ex1;

public class PromoCodeDiscount implements DiscountBehaviour {

    @Override
    public double getDiscount() {
        return 10.0;
    }
}
