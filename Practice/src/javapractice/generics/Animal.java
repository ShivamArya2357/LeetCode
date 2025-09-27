package Practice.src.javapractice.generics;

public class Animal {

    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public void print() {
        System.out.println("I am animal");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
