package Practice.src.designpattern.strategy.impl;

public class QuackSqueak implements QuackBehaviour {

    @Override
    public void quack() {
        System.out.println("[Quack] Squeak!");
    }
}
