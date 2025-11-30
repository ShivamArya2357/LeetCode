package Practice.src.designpattern.strategy.impl;

public class FlyNoWay implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("[Fly] I can’t fly.");
    }
}
