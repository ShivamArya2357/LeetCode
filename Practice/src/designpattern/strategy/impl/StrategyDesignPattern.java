package Practice.src.designpattern.strategy.impl;

public class StrategyDesignPattern {

    public static void main(String[] args) {

        Duck mallard = new MallardDuck();
        mallard.display();
        mallard.performQuack();  // Quack
        mallard.performFly();    // Fly with wings

        System.out.println();

        Duck rubber = new RubberDuck();
        rubber.display();
        rubber.performQuack();   // Squeak
        rubber.performFly();     // Can't fly

        System.out.println();

        Duck decoy = new DecoyDuck();
        decoy.display();
        decoy.performQuack();    // Silence
        decoy.performFly();      // Can't fly

        System.out.println();

        Duck rocket = new RocketDuck();
        rocket.display();
        rocket.performQuack();   // Quack
        rocket.performFly();     // Rocket powered

        System.out.println("\n=== Runtime Behavior Change ===");
        // Rubber duck picks up rocket at runtime
        rubber.setFlyBehaviour(new FlyRocketPowered());
        rubber.performFly(); // Now rocket-powered!

        // Mallard loses its voice at runtime
        mallard.setQuackBehaviour(new QuackMute());
        mallard.performQuack(); // Now silent
    }
}
