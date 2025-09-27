package Practice.src.designpattern.strategy.impl;

public class FlyWithWings implements FlyBehaviour {

    @Override
    public void fly() {
        System.out.println("[Fly] Flapping wings and flying!");
    }
}
