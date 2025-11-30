package Practice.src.javapractice.generics;

public class Dog extends Animal {

    public Dog(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println("I am Dog");
    }
}
