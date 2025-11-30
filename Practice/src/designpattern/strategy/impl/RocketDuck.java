package Practice.src.designpattern.strategy.impl;

public class RocketDuck extends Duck {

    public RocketDuck() {
        super(new FlyRocketPowered(), new QuackNormal());
    }

    @Override
    public void display() {
        System.out.println("[Display] I’m a Rocket Duck!");
    }
}
