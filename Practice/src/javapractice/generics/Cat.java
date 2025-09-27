package Practice.src.javapractice.generics;

public class Cat extends Animal {

    public Cat(String name) {
        super(name);
    }

    @Override
    public void print() {
        System.out.println("I am Cat");
    }
}
