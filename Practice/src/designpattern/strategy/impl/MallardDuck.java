package Practice.src.designpattern.strategy.impl;

public class MallardDuck extends Duck {

    public MallardDuck() {
        super(new FlyWithWings(), new QuackNormal());
    }

    @Override
    public void display() {
        System.out.println("[Display] I’m a Mallard Duck.");
    }
}
