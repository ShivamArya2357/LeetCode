package Practice.src.designpattern.strategy.impl;

public class QuackMute implements QuackBehaviour {

    @Override
    public void quack() {
        System.out.println("[Quack] << silence >>");
    }
}
