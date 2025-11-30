package Practice.src.designpattern.strategy.impl;

public class DecoyDuck extends Duck {

    public DecoyDuck() {
        super(new FlyNoWay(), new QuackMute());
    }

    @Override
    public void display() {
        System.out.println("[Display] I’m a Wooden Decoy Duck.");
    }
}
