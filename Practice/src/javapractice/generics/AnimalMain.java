package Practice.src.javapractice.generics;

import java.util.ArrayList;
import java.util.List;

public class AnimalMain {

    public static void main(String[] args) {

        List<Animal> dogs = new ArrayList<>();
        dogs.add(new Dog("D:A"));
        dogs.add(new Dog("D:B"));
        dogs.add(new Dog("D:C"));
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat("C:A"));
        cats.add(new Cat("C:B"));
        cats.add(new Cat("C:C"));
        print(dogs);
        print(cats);
    }

    private static void print(List<? extends Animal> animals) {

        for (Animal animal : animals) {
            System.out.print(animal.getName() + " ");
        }
        System.out.println();
    }
}
