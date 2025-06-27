package Practice.src.javapractice;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class PS2 {

    public static void main(String[] args) {

        User user1 = new User("shivam2357", "singh1.shivam2357@gmail.com", "123456");
//        User user2 = new User("shaurya4567", "singh1.shaurya4567@gmail.com", "234567");
//        User user3 = new User("manisha4564", "manisha4564@gmail.com", "7568579");
//        List<User> users = new ArrayList<>();
//        users.add(user1);
//        users.add(user2);
//        users.add(user3);

        List<Predicate<User>> validations = List.of(
                user -> user.getUsername() != null && !user.getUsername().isEmpty(),
                user -> user.getEmail() != null && user.getEmail().contains("@"),
                user -> user.getEmail().endsWith(".com"),
                user -> user.getPassword() != null && user.getPassword().length() >= 8,
                u -> u.getPassword().matches(".*\\d.*")
        );
        validations.stream().allMatch(rule -> rule.test(user1));
    }
}
