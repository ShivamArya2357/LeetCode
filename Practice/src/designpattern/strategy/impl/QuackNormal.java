package Practice.src.designpattern.strategy.impl;

public class QuackNormal implements QuackBehaviour {

    @Override
    public void quack() {
        System.out.println("[Quack] Quack! Quack!");
    }
}
