package Practice.src.designpattern.strategy.impl;

public class RubberDuck extends Duck {

    public RubberDuck() {
        super(new FlyNoWay(), new QuackSqueak());
    }

    @Override
    public void display() {
        System.out.println("[Display] I’m a Rubber Duck.");
    }
}
