package com.izeye.adventofcode.year2020.day1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * "Day 1: Report Repair" from "Advent of Code 2020".
 *
 * @author Johnny Lim
 */
public class ReportRepair {

    public static void main(String[] args) throws IOException {
        List<Integer> numbers = new ArrayList<>();
        try (InputStream inputStream = ReportRepair.class.getClassLoader().getResourceAsStream("year2020/day1/input.txt");
             InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
             BufferedReader bufferedReader = new BufferedReader(inputStreamReader)) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.valueOf(line));
            }
        }

        int part1Answer = getPart1Answer(numbers);
        System.out.println(part1Answer);

        int part2Answer = getPart2Answer(numbers);
        System.out.println(part2Answer);
    }

    private static int getPart1Answer(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 1; i++) {
            Integer first = numbers.get(i);
            for (int j = i + 1; j < numbers.size(); j++) {
                Integer second = numbers.get(j);
                if (first + second == 2020) {
                    return first * second;
                }
            }
        }
        throw new IllegalArgumentException("An answer is expected.");
    }

    private static int getPart2Answer(List<Integer> numbers) {
        for (int i = 0; i < numbers.size() - 2; i++) {
            Integer first = numbers.get(i);
            for (int j = i + 1; j < numbers.size() - 1; j++) {
                Integer second = numbers.get(j);
                for (int k = j + 1; k < numbers.size(); k++) {
                    Integer third = numbers.get(k);
                    if (first + second + third == 2020) {
                        return first * second * third;
                    }
                }
            }
        }
        throw new IllegalArgumentException("An answer is expected.");
    }

}
