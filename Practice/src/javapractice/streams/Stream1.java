package Practice.src.javapractice.streams;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream1 {

    static class Order {
        String orderId;
        String customerName;
        double amount;
        String status; // e.g., "PLACED", "SHIPPED", "DELIVERED", "CANCELLED"

        // constructor + getters


        public Order(String orderId, String customerName, double amount, String status) {
            this.orderId = orderId;
            this.customerName = customerName;
            this.amount = amount;
            this.status = status;
        }

        public double getAmount() {
            return amount;
        }
    }

    public static void main(String[] args) {

//        List<Integer> list1 = Arrays.asList(1, 2, 3);
//        List<Integer> list2 = Arrays.asList(4, 5);
////        List<int[]> pairs = list1.stream()
        List<Order> orders = List.of(
                new Order("O1", "Alice", 120.5, "PLACED"),
                new Order("O2", "Bob", 300.0, "DELIVERED"),
                new Order("O3", "Alice", 150.0, "DELIVERED"),
                new Order("O4", "Charlie", 200.0, "CANCELLED"),
                new Order("O5", "Bob", 450.0, "DELIVERED")
        );

        double total = orders.stream().mapToDouble(order -> order.getAmount()).sum();
        System.out.println(total);
    }
}
