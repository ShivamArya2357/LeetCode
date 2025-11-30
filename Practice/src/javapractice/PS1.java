package Practice.src.javapractice;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import java.util.function.Function;

public class PS1 {

    public static void main(String[] args) {

        List<String> lines = List.of("  hello ", "world  ", " java  ");
        List<String> operations = List.of("UPPERCASE", "ADD_PREFIX");

        Map<String, Function<String, String>> functionMap = Map.of(
                "UPPERCASE", s -> s.toUpperCase(),
                "TRIM", s -> s.trim(),
                "ADD_PREFIX", s -> ">>" + s
        );
        Function<String, String> pipeLine = Function.identity();
        for (String operation : operations) {
            pipeLine = pipeLine.andThen(functionMap.get(operation));
        }
        for (String line : lines) {
            System.out.println(pipeLine.apply(line));
        }
    }
}
