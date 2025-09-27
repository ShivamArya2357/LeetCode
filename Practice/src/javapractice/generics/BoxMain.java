package Practice.src.javapractice.generics;

public class BoxMain {

    public static void main(String[] args) {

        Box<String> box1 = new Box<>();
        box1.setValue("hello");
        Box<Integer> box2 = new Box<>();
        box2.setValue(2);
        printBox(box1);
        printBox(box2);
    }

    private static void printBox(Box<?> box) {

        System.out.println(box.getValue());
    }
}
