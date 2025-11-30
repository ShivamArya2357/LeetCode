package Practice.src.designpattern.strategy.impl;

public class FlyRocketPowered implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("[Fly] ZOOOM! Rocket-powered flight!");
    }
}
