package techcourse.fp.mission;

import java.util.List;
import java.util.function.IntPredicate;

public class Calculator {

    public static int sumAll(List<Integer> numbers) {
        return getSum(numbers, number -> true);
    }

    public static int sumAllEven(List<Integer> numbers) {
        return getSum(numbers, number -> number % 2 == 0);
    }

    public static int sumAllOverThree(List<Integer> numbers) {
        return getSum(numbers, number -> number > 3);
    }

    private static int getSum(List<Integer> numbers, IntPredicate conditional) {
        return numbers.stream()
                .mapToInt(Integer::intValue)
                .filter(conditional)
                .sum();
    }
}
