package techcourse.fp.mission;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamStudy {

    public static long countWords() throws IOException {
        return Arrays.stream(Files.readString(Paths
                                .get("src/main/resources/fp/war-and-peace.txt"))
                        .split("[\\P{L}]+"))
                .filter(word -> word.length() > 12)
                .count();
    }

    public static List<Integer> doubleNumbers(List<Integer> numbers) {
        return numbers.stream()
                .map(number -> number * 2)
                .collect(Collectors.toList());
    }

    public static long sumAll(List<Integer> numbers) {
        return numbers.stream()
                .mapToLong(Integer::longValue)
                .sum();
    }

    public static long sumOverThreeAndDouble(List<Integer> numbers) {
        return numbers.stream()
                .mapToLong(Integer::longValue)
                .filter(number -> number > 3)
                .sum() * 2;
    }

    public static void printLongestWordTop100() throws IOException {
        String contents = Files.readString(Paths
                .get("src/main/resources/fp/war-and-peace.txt"));
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        words.stream()
                .filter(word -> word.length() > 12)                       // 단어의 길이가 12자를 초과하는 단어를 추출한다.
                .map(String::toLowerCase)                                 // 모든 단어를 소문자로 변경한다.
                .distinct()                                               // 단어 중복을 제거한다.
                .sorted(Comparator.comparing(String::length).reversed())  // 긴 순서로 정렬한다.
                .limit(100)                                               // 100개의 단어를 추출한다.
                .forEach(System.out::println);                            // 추출한 100개의 단어를 출력한다.
    }
}
